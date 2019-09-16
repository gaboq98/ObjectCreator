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
    private Stack<Sphere> stack = new Stack<>();
    
    public SpherePool(int min, int max) {
        MIN = min;
        MAX = max;
    }
    
    public void initPool(CanvasPanel canvas, Color color,  String direction, int speed) {
        for (int c = stack.size(); c < MIN; c++) {
            Sphere sphere = new Sphere(canvas, color, direction, speed);
            stack.push(sphere);
        }
    }
    
    public Sphere newInstancePool(CanvasPanel canvas, Color color,  String direction, int speed){
        int i = stack.size();
        if (i < MAX){
            Sphere sphere = new Sphere(canvas, color, direction, speed);
            stack.push(sphere);
        }
        return stack.pop();
    }
    
    @Override
    public Sphere getObject() {
        return (Sphere) stack.pop();
    }

    @Override
    public void releaseObject(Sphere sphere) {
        stack.push(sphere);
    }

    
}

