/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

/**
 *
 * @author Pumkin
 */
import java.util.HashMap;   

public class PrototypeFactory {
    // hash de prototypes por nombre
    private static HashMap<String,IPrototype> prototypes = new HashMap<>();       
    
    // getPrototype del hash por nombre, pero CLONADO
    public static IPrototype getPrototype(String prototypeName){           
        //return prototypes.get(prototypeName).deepClone();   
        return prototypes.get(prototypeName).clone(); 
    }       
    
    // add prototype al hash
    public static void addPrototype(String prototypeName,IPrototype prototype){   
        prototypes.put(prototypeName, prototype);   
    }
    
    // checks if in Hashmap
    public static Boolean checkProtoype(String prototypeName){
        return prototypes.containsKey(prototypeName);
    }
}
