/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import beans.beautifulthing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.InjectionException;

/**
 *
 * @author framawy
 */

@Alternative

public class databaseService implements DataBaseInterface{
    
    String dbURL = "jdbc:mysql://localhost:3306/beautifulthings?zeroDateTimeBehavior=convertToNull";
            String user = "root";
            String pw = "";
    
    
    
    
    @Override
    public int deleteoneitem(int id ){
        
        int numberofrowaffected = 0;
        
        //DatabaseWork
         try {
            // Connect
            
            int rowAffected = 0;
            
            
            
            Connection c = null;
             PreparedStatement stmt = null;
         
            
            c = DriverManager.getConnection(dbURL, user, pw);
            System.out.println("Connection is successful " + dbURL + " user " +user);
            
            //Creat a SQL statement
            stmt = c.prepareStatement("delete from `thingstable` where Id = ?");
            stmt.setInt(1, id);
            //execute the statement
          rowAffected = stmt.executeUpdate();
            //Success message
            
           
            stmt.close();
             c.close();
            
        } catch (SQLException ex) {
            System.out.println("Error Communication with database");
            ex.printStackTrace();
        } 
             
       return numberofrowaffected;
    }
    
    @Override
    public int insertone(beautifulthing b) {
         
         int NumberofRowsAffected =0;
        
        //databaseWOrk
        try {
            // Connect
            
            int rowAffected = 0;
            
            
            Statement stmte = null;
            Connection c = null;
            PreparedStatement Pstmt = null;
          ResultSet rs= null;
            
            c = DriverManager.getConnection(dbURL, user, pw);
            
            
            //Creat a SQL statement
             stmte = c.createStatement();
         String StrtAuto = "SELECT MAX(Id) + 1 as AUTONUM FROM thingstable";
           stmte.executeQuery(StrtAuto);
            String MaxNum = "";
        while(stmte.getResultSet().next()){
            MaxNum = stmte.getResultSet().getString("AUTONUM");
            
        }
        
       
         
            Pstmt = c.prepareStatement("INSERT INTO `thingstable` (`Id`, `thing-title`, `thing-description`, `thing-value`) "
                    + "VALUES ( "+ MaxNum  +" , ? , ? , ?)");
            Pstmt.setString(1, b.getThingTitle());
            Pstmt.setString(2, b.getThingDescription());
            Pstmt.setInt(3, b.getRating());
            //execute the statement
            rowAffected = Pstmt.executeUpdate();
                   
            //Success message
            System.out.println("Row Inserted " + rowAffected);
          
           
        
        Pstmt.close();
        c.close();
        
             
        } catch (SQLException ex) {
            System.out.println("Error Communication with database");
            ex.printStackTrace();
        }
        
    
        
        return NumberofRowsAffected;
    }
    
    @Override
    public ArrayList<beautifulthing> readALl(){
        ArrayList<beautifulthing> everyone = new ArrayList<>();
        beautifulthing b;
        //databaseWork
         try {
            // Connect
           
            Connection c = null;
            Statement stmt = null;
            ResultSet rs = null;
            
            c = DriverManager.getConnection(dbURL, user, pw);
            System.out.println("Connection is successful " + dbURL + " user " +user);
            
            //Creat a SQL statement
            stmt = c.createStatement();
            
            //execute the statement
            rs = stmt.executeQuery("SELECT * FROM `thingstable`");
            //process the rows in in the result set
            while(rs.next()){
                
               
                b = new beautifulthing(rs.getInt("Id") , rs.getString("thing-title"), rs.getString("thing-description") , rs.getInt("thing-value"));
                
                everyone.add(b);
            }
            
           
            
        } catch (SQLException ex) {
            System.out.println("Error Communication with database");
            ex.printStackTrace();
        } 
        
        return everyone;
    }
    
    @Override
    public int UpdateOne(int id , beautifulthing b){
      
        int numberofrowAffected = 0;
        //databaseWOrk
            
        try {
            // Connect
            
            Connection c = null;
            PreparedStatement stmt = null;
          int rowsAffected =0; 
            
            c = DriverManager.getConnection(dbURL, user, pw);
            System.out.println("Connection is successful " + dbURL + " user " +user);
            
            //Creat a SQL statement
            stmt = c.prepareStatement("UPDATE `thingstable` SET `thing-title`= ?,`thing-description`= ?,`thing-value`= ?  WHERE Id = ?");
            stmt.setString(1, b.getThingTitle());
            stmt.setString(2, b.getThingDescription());
            stmt.setInt(3, b.getRating());
            stmt.setInt(4, id);
            //execute the statement
            rowsAffected = stmt.executeUpdate();
            //Success message 
            
            System.out.println("rowsaffected " + rowsAffected);
            
           stmt.close();
            c.close();
        
        } catch (SQLException ex) {
            System.out.println("Error Communication with database");
            ex.printStackTrace();
        } 
            
            
            
    
        
       
        return numberofrowAffected;
    }
}
