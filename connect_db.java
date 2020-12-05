/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.mangement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hassam
 */
public class connect_db {
    
    Connection con;

    /**
     *
     */
    public void connect_to_db(){
        try{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
       // String url = "jdbc:derby://localhost:1527/projectdb";
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/projectdb","hassam","admin");
        if(con!=null){
            System.out.print("connected");
        }
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Wrong driver");
        }
    }
    
    
    
    
    
}

