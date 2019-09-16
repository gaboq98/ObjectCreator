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

import Model.IShape;
import Model.Sphere;
import Model.SphereTypes;
import java.awt.Color;

public class SphereFactory {  
    
    /**
     *
     * 
     */
    public static IShape getSphere(SphereTypes type) {
        Sphere sphere = new Sphere();
        switch(type) {
            case blackS:
                sphere.setColor(Color.BLACK);
                break;
            case redS:
                sphere.setColor(Color.RED);
                break;
            case yellowS:
                sphere.setColor(Color.YELLOW);
                break;
            case greenS:
                sphere.setColor(Color.GREEN);
                break;
            case blueS:
                sphere.setColor(Color.BLUE);
                break;
        }
        return sphere;
    }
}