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
    
    private int size;
    Color color;
    private int direction;
    private int speed;
    private int pattern;
    private CanvasPanel canvas;
    private int time;
    HashMap<String, Color> colors;

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

    public List<IShape> create(int size, String color, String direction, int speed, String pattern) {
        List<IShape> shapes = new ArrayList<>();
        switch(pattern) {
            case "Prototype":
                break;
            case "Factory Method":
                break;
            case "Builder":
                break;
            case "Object Pool":
                break;
            default:
                for(int i=0; i < size; i++) {
                    shapes.add( new Sphere(canvas, colors.get(color), direction, speed) );
                }
                break;
        }
        return shapes;
    }
    
}
