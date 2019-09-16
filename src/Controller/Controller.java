/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.CanvasPanel;
import Model.IShape;
import Model.Sphere;
import Model.Sphere.SphereBuilder;
import static Model.SphereTypes.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Patterns.PrototypeFactory;
import Patterns.SphereFactory;
import Patterns.SpherePool;

/**
 *
 * @author Gabriel
 */
public class Controller {
    
    Color color;
    private CanvasPanel canvas;
    private long time;
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
    
    //final SpherePool pool = new SpherePool(1, 100, 1000, new SphereFactory());
    
    public List<IShape> create(int size, String color, String direction, int speed, String pattern) {
        List<IShape> shapes = new ArrayList<>();
        long startTime = 0;
        long endTime = 0;
        switch(pattern) {
            case "Prototype":
                startTime = System.currentTimeMillis();
                for(int i=0; i < size; i++) {
                    if(PrototypeFactory.checkProtoype("sphere" + color + direction + speed)){
                        shapes.add((Sphere) PrototypeFactory.getPrototype("sphere" + color + direction + speed));
                    }else{
                        Sphere Sphere = new Sphere(canvas, colors.get(color), direction, speed);
                        PrototypeFactory.addPrototype("sphere" + color + direction + speed, Sphere);
                        shapes.add(Sphere);
                    }
                }
                endTime = System.currentTimeMillis();
                this.time = endTime - startTime;
                break;
            case "Factory Method":
                startTime = System.currentTimeMillis();
                for(int i=0; i < size; i++) {
                    Sphere sphere = null;
                    switch(color) {
                        case "Negro":
                            sphere = (Sphere) SphereFactory.getSphere(blackS);
                            break;
                        case "Rojo":
                            sphere = (Sphere) SphereFactory.getSphere(redS);
                            break;
                        case "Amarillo":
                            sphere = (Sphere) SphereFactory.getSphere(yellowS);
                            break;
                        case "Verde":
                            sphere = (Sphere) SphereFactory.getSphere(greenS);
                            break;
                        case "Azul":
                            sphere = (Sphere) SphereFactory.getSphere(blueS);
                            break;
                    }
                    sphere.setCanvas(canvas);
                    sphere.setDirection(direction);
                    sphere.setRatio(speed);
                    shapes.add(sphere);
                }
                endTime = System.currentTimeMillis();
                this.time = endTime - startTime;
                break;
            case "Builder":
                startTime = System.currentTimeMillis();
                for(int i=0; i < size; i++) {
                    Sphere sphere= new SphereBuilder()
                            .setCanvas(canvas)
                            .setColor(colors.get(color))
                            .setDirection(direction)
                            .setRatio(speed).build();
                    shapes.add(sphere);
                }
                endTime = System.currentTimeMillis();
                this.time = endTime - startTime;
                break;
            case "Object Pool":
                startTime = System.currentTimeMillis();
                for(int i=0; i < size; i++) {
                
                }
                endTime = System.currentTimeMillis();
                this.time = endTime - startTime;
                break;
            default:
                startTime = System.currentTimeMillis();
                for(int i=0; i < size; i++) {
                    shapes.add( new Sphere(canvas, colors.get(color), direction, speed) );
                }
                endTime = System.currentTimeMillis();
                this.time = endTime - startTime;
                break;
        }
        System.out.println("Time in miliseconds: " + this.time);
        return shapes;
    }

    public long getTime() {
        return time;
    }
    
    
}
