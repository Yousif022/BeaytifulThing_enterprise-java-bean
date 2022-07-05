/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import beans.beautifulthing;
import com.sun.jersey.spi.inject.Inject;
import database.DataBaseInterface;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;


@Alternative

public class BusinessService1 implements BusinessServiceInterface {

    @Inject 
   private DataBaseInterface db;
    
    
    @Override
    public int deleteoneitem(int id) {
        return db.deleteoneitem(id);
    }

    @Override
    public int insertone(beautifulthing b) {
       return db.insertone(b);
    }

    @Override
    public ArrayList<beautifulthing> readALl() {
       return db.readALl();
    }

    @Override
    public int UpdateOne(int id, beautifulthing b) {
        return db.UpdateOne(id, b);
    }
    
}
