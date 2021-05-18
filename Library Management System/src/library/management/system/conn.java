package library.management.system;


import java.sql.*;  
import javax.swing.JOptionPane;

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6412718","sql6412718","k2WX6lhasq");    
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(null, "Network Error");
            System.out.println(e);
        }  
    }  
}  
