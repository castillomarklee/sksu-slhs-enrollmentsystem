/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author castillo
 */
public class DBconnetion {
    Connection con;
    
    public void doConnect() {
        String url = "jdbc:postgresql://localhost:5432/informationsystemdb";
        String user = "postgres";
        String pass = "12345";
        
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,user,pass);
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error" + e.getMessage());
        }
    }
}
