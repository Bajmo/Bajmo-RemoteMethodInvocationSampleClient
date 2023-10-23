/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import dao.IDao;
import entities.Machine;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientTest {

    public static void main(String[] args) {
        try {
            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");
            dao.create(new Machine("S23", "HP", 2000));
            dao.create(new Machine("S63", "LENOVO", 3000));
            dao.create(new Machine("S83", "HP", 2000));
            for (Machine m : dao.findAll()) {
                System.out.println(m);
            }
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
