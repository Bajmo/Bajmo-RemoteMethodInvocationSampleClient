/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import tests.URLTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static String getUrl() {
        String url = null;
        FileInputStream f = null;
        try {
            f = new FileInputStream("config.properties");
            Properties p = new Properties();
            p.load(f);
            url = p.getProperty("url");
        } catch (FileNotFoundException e) {
            Logger.getLogger(URLTest.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(URLTest.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                f.close();
            } catch (IOException e) {
                Logger.getLogger(URLTest.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return url;
    }
}
