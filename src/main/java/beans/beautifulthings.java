/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author framawy
 */
public class beautifulthings {
    
    ArrayList<beautifulthing> TheList = new ArrayList <beautifulthing>();
    
    
    public void add(beautifulthing bt){
        
        TheList.add(bt);
    }
    
    public void printAll(){
        System.out.println("============= these are a few of my beautifulthing =====================");
        
        for(beautifulthing bt : TheList){
            
   System.out.println("ID = " + bt.id + "title = " + bt.thingTitle + "Desc :" + bt.thingDescription + "Rating :" + bt.rating);
        }
        System.err.println("========== End of the list ==============");
    }
}
