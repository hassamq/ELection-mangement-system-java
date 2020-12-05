/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.mangement;

import com.sun.jdi.connect.spi.Connection;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.derby.iapi.sql.ResultSet;

/**
 *
 * @author hassam
 */
public class votercheck extends connect_db {
   public Boolean checkcninc(String ent_cnic){
        try{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/projectdb","hassam","admin");
        java.sql.Statement stmt = con.createStatement();
        String DBQ="Select * from HASSAM.VOTERS where CNIC = '"+ent_cnic+"'";
        java.sql.ResultSet rs = stmt.executeQuery(DBQ);
        if(rs.next()){
            return true;
        }
        else{
            return false;
        }
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Wrong driver");
        }
        
        
       
   
        return null;
  
}
   
    
    
    
    
    void addvote(String party){
         try{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/projectdb","hassam","admin");
        java.sql.Statement stmt = con.createStatement();
        String DBQ="Select * from HASSAM.VOTECOUNT where PARTYNAME = '"+party+"'";
        java.sql.ResultSet rs = stmt.executeQuery(DBQ);
        if(rs.next()){
            int count=0;
            
            //fetching from database
            String sql1="select * from votecount";
            Statement ps= con.createStatement();
            java.sql.ResultSet rs1;
            rs1 = ps.executeQuery(sql1);
            while(rs1.next()){
                if(rs1.getString(1).equals(party)){
                    count=rs1.getInt(2);
                       
                        count++;
                }
                
            }
            
            
            //Saving in the database
            
             String upd="update votecount set COUNT="+count+"  where PARTYNAME='"+party+"'";  
              Statement st;
            st = con.createStatement();
        st.executeUpdate(upd);
       // JOptionPane.showMessageDialog(null, "Data updated Sucessfully");
            
            
            
            
            
            
        }
        else{
            int i=1;
            
            
            String sql = "insert into votecount values(?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, party);
                ps.setInt(2,i);
                ps.execute();
              
        }
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Wrong driver");
        }
   }
    


 

}

    
