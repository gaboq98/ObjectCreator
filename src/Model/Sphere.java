/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.CanvasPanel;
import Patterns.IObjectPool;
import java.awt.Color;
import java.awt.Graphics;
import Patterns.IPrototype;

/**
 *
 * @author Gabriel
 */
public class Sphere implements IPrototype, IShape, Runnable{
    
    private int SIZE = 10;
    private int WIDTH = 500;
    private int HEIGHT = 500;
    private int SPEED = 60;
    private int MOVEMENT = 5;
    private String direction;
    private float ratio;
    private Color color;
    private int x;
    private int y;
    
    private Thread thread;
    private CanvasPanel canvas;
    
    private int uses;
    private static int invalidate;
    
    public Sphere() {
        thread = new Thread(this);
        x = (int) Math.floor(Math.random()*WIDTH);
        y = (int) Math.floor(Math.random()*HEIGHT);
    }
    
    public Sphere(CanvasPanel canvas) {
        thread = new Thread(this);
        x =  (int) Math.floor(Math.random()*WIDTH);
        System.out.println(Math.floor(Math.random()*WIDTH));
        y = (int) Math.floor(Math.random()*WIDTH);
        color = Color.BLUE;
        this.canvas = canvas;
        ratio = (float) 0.3;
    }
    
    public Sphere(CanvasPanel _canvas, Color _color,  String _direction, int _ratio) {
        thread = new Thread(this);
        x = (int) Math.floor(Math.random()*WIDTH);
        y = (int) Math.floor(Math.random()*HEIGHT);
        color = _color;
        canvas = _canvas;
        ratio = (float) _ratio/10;
        direction = _direction;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio/10;;
    }

    public void setCanvas(CanvasPanel canvas) {
        this.canvas = canvas;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);       
    }
    
     @Override
    public void move() throws InterruptedException {
        switch(direction) {
            case "0°":
                move0();
                break;
            case "45°":
                move45();
                break;
            case "90°":
                move90();
                break;
            case "135°":
                move135();
                break;
            case "180°":
                move180();
                break;
            case "225°":
                move225();
                break;
            case "270°":
                move270();
                break;
            case "315°":
                move315();
                break;
        }
    }
    
    public void move0() throws InterruptedException {
        while(x < (WIDTH-SIZE) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
        }
        while( (x > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
        }
    }
    
    public void move45() throws InterruptedException {
        while(x < (WIDTH-SIZE) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
            y -= MOVEMENT;
        }
        while( (y > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
            y -= MOVEMENT;
        }
        while( (x > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
            y += MOVEMENT;
        }
        while( (y < (HEIGHT-SIZE)) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
            y += MOVEMENT;
        }
    }
    
    public void move90() throws InterruptedException {
        while( (y > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            y -= MOVEMENT;
        }
        while( (y < (HEIGHT-SIZE)) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            y += MOVEMENT;
        }
    }
    
    public void move135() throws InterruptedException {
        while( (x > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
            y -= MOVEMENT;
        }
        while( (y > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
            y -= MOVEMENT;
        }
        while(x < (WIDTH-SIZE) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
            y += MOVEMENT;
        }
        while( (y < (HEIGHT-SIZE)) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
            y += MOVEMENT;
        }
    }
    
    public void move180() throws InterruptedException {
        while(x < (WIDTH-SIZE) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
        }
        while( (x > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
        }
        while(x < (WIDTH-SIZE) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
        }
        while( (x > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
        }
    }
    
    public void move225() throws InterruptedException {
        while( (x > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
            y += MOVEMENT;
        }
        while( (y < (HEIGHT-SIZE)) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
            y += MOVEMENT;
        }
        while(x < (WIDTH-SIZE) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
            y -= MOVEMENT;
        }
        while( (y > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
            y -= MOVEMENT;
        }
    }
    
    public void move270() throws InterruptedException {
        while( (y < (HEIGHT-SIZE)) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            y += MOVEMENT;
        }
        while( (y > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            y -= MOVEMENT;
        }
    }
    
    public void move315() throws InterruptedException {
        while(x < (WIDTH-SIZE) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
            y += MOVEMENT;
        }
        while( (y < (HEIGHT-SIZE)) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
            y += MOVEMENT;
        }
        while( (x > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x -= MOVEMENT;
            y -= MOVEMENT;
        }
        while( (y > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep((long) (SPEED*ratio));
            x += MOVEMENT;
            y -= MOVEMENT;
        }
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                move();
            }
        } catch (Exception e) {
        }
    }
    
    public void start() {
        if (!thread.isAlive()) {
            thread.start();
        }
    }

               
    @Override
    public Sphere clone() {
        return new Sphere(this.canvas, this.color, this.direction, (int)(this.ratio*10));
    }
    
     public static class SphereBuilder implements IBuilder<Sphere>{
         
         private String direction;
         private float ratio;
         private Color color;
         private CanvasPanel canvas;
         
         public SphereBuilder(){
         }
         
         public SphereBuilder setDirection(String direction) {
             this.direction = direction;
             return this;
         }
         public SphereBuilder setRatio(float ratio) {
             this.ratio = ratio;
             return this;
         }
         
         public SphereBuilder setColor(Color color) {
             this.color = color;
             return this;
         }

         public SphereBuilder setCanvas(CanvasPanel canvas) {
             this.canvas = canvas;
             return this;
         }

         
         @Override
         public Sphere build() {
             return new Sphere(canvas, color, direction, (int)ratio);
         }
         
     }
}
