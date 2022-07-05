/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import beans.beautifulthing;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author framawy
 */

public interface BusinessServiceInterface {
    
    public int deleteoneitem(int id );
     public int insertone(beautifulthing b);
     public ArrayList<beautifulthing> readALl();
     public int UpdateOne(int id , beautifulthing b);
}
