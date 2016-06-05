/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocerveza;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Oracle
 */
public class dbConnection {
    private static final String conexion="jdbc:mysql://localhost/cerveceria?characterEncoding=UTF-8&useSSL=false";
    public static Connection conectDB(){
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con= DriverManager.getConnection(conexion,"root","varazul95");
          return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    
        return null;
    }
     
        
      
}
