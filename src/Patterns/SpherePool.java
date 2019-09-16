/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import GUI.CanvasPanel;
import Model.Sphere;
import java.awt.Color;
import java.util.Stack;

/**
 *
 * @author Pumkin
 */
public class SpherePool implements IObjectPool{

    private final int MAX;
    private final int MIN;
    private Stack stack;
    
    public SpherePool(int min, int max , CanvasPanel canvas, Color color,  String direction, int speed) {
        MIN = min;
        MAX = max;
        stack = new Stack();
    }
    
    public void initPool(CanvasPanel canvas, Color color,  String direction, int speed) {
        
    }
    
    @Override
    public IObjectPool getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void releaceObject(IObjectPool pooledObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

