/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.CanvasPanel;
import Model.IShape;
import Model.Sphere;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Controller {
    
    private CanvasPanel canvas;
    HashMap<String, Color> colors;
    long duration;

    public Controller() {
        //
    }

    public Controller(CanvasPanel canvas) {
        this.canvas = canvas;
        colors = new HashMap<>();
        colors.put("Negro", Color.BLACK);
        colors.put("Rojo", Color.RED);
        colors.put("Verde", Color.GREEN);
        colors.put("Amarillo", Color.YELLOW);
        colors.put("Azul", Color.BLUE);
    }

    public long getDuration() {
        return duration;
    }

    public List<IShape> create(int size, String color, String direction, int speed, String pattern) {
        List<IShape> shapes = new ArrayList<>();
        long startTime;
        long endTime;
        switch(pattern) {
            case "Prototype":
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                break;
            case "Factory Method":
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                break;
            case "Builder":
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                break;
            case "Object Pool":
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                break;
            default:
                startTime = System.nanoTime();
                for(int i=0; i < size; i++) {
                    shapes.add( new Sphere(canvas, colors.get(color), direction, speed) );
                }
                endTime = System.nanoTime();
                break;
        }
        duration = (endTime - startTime) / 1000000;
        return shapes;
    }
    
}
