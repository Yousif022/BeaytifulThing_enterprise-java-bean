/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import beans.beautifulthing;
import business.BusinessServiceInterface;
import com.sun.jersey.spi.inject.Inject;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;


/**
 *
 * @author framawy
 */
@ManagedBean

public class FormController {
    
    @Inject
    BusinessServiceInterface bs;
    
    public String OnSubmit() throws SQLException{   
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
        // store the "get" values in an object
        beautifulthing b = context.getApplication().evaluateExpressionGet(context,"#{beautifulthing}", beautifulthing.class);
        //hold the value of the object that was in the web page
        
        System.out.println("The Object you entered is : " + b.getThingTitle());
        //put the get values into a response page
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulthing", b);
        //store the object in the database
        
        bs.insertone(b); 
         
       //show the response page.
        
       return "ResponsePage.xhtml";
    }
    public  ArrayList<beautifulthing> GetAll(){
        
        return bs.readALl();
       
    }
    public String deleteOn(beautifulthing b) throws SQLException{
        
        
        System.out.println("The Object you deleted is : " + b.getThingTitle());
        bs.deleteoneitem(b.getId());
        
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulthing", b);
       
        return "ResponsePage.xhtml";
    }
    
    public String OnShowEdit(beautifulthing b){
        
        System.out.println("The Object you deleted is : " + b.getThingTitle());
        
         FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulthing", b);
        return "EditForm.xhtml";    
    }     
    public String OnSubmitEdit() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       beautifulthing b = context.getApplication().evaluateExpressionGet(context,"#{beautifulthing}", beautifulthing.class);
       
       //hold the value of the object that was in the web page
       
       System.out.println("The Object you Edited is : " + b.getThingTitle());
       
       
       //put the get values into a response page 
       FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulthing", b);
      
       //store the object in the database 
      
       bs.UpdateOne(b.getId(), b);
       
      
       
       //show the response page.
        
       return "ResponsePage.xhtml";
}
     public String showEntryForm(){
         
         return "EntryForm.xhtml";
     }
     public String showAll(){
         
         return "index.xhtml";
     }
             
     
}