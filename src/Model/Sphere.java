/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.CanvasPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Gabriel
 */
public class Sphere implements IShape, Runnable{
    
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
    
    public Sphere() {
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
        if(true) {
            move45();
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
}
