/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.mangement;

import com.sun.jdi.connect.spi.Connection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hassam
 */
public class voters {
    String cnic,firstname,secondname,fathername,gender,province,city,address;
    int age;
    int r;

    public voters(String cnic, String first_name, String second_name, String father_name, String gender, String province, String city, String address, int age) {
        this.cnic = cnic;
        this.firstname = first_name;
        this.secondname = second_name;
        this.fathername = father_name;
        this.gender = gender;
        this.province = province;
        this.city = city;
        this.address = address;
        this.age = age;
    }
    public voters(){
        
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
    

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getCnic() {
        return cnic;
    }

    public String getFathername() {
        return fathername;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getGender() {
        return gender;
    }

    public String getProvince() {
        return province;
    }

    public String getSecondname() {
        return secondname;
    }
    void display(){
        System.out.println(cnic);
        System.out.println(fathername);
    }
    
    void addtocast(String ent_cnic){
        try {
            FileWriter writer = new FileWriter("casted.txt",true);
            writer.write("\n"+ent_cnic);
            //writer.write(System.getProperty("line.seperator"));
            writer.close();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
            Logger.getLogger(voters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   int casted(String ent_cnic){
        File f = new File("casted.txt");
        try {
            Scanner reader = new Scanner(f);
            String check=null;
           
            
            while(reader.hasNextLine()){
                check=reader.nextLine();
                
                
                
              }
            
            if(check.equals(ent_cnic)){
                   
                    r=1;
                }
                else{
                    r =0;
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(voters.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return r;
    }
   
}
