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
public class Sphere implements Runnable{
    
    private int x;
    private int y;
    private int SIZE = 10;
    private int WIDTH = 500;
    private int HEIGHT = 500;
    private Color color;
    private Thread thread;
    private CanvasPanel canvas;

    public Sphere() {
        thread = new Thread(this);
        x = WIDTH/2-SIZE;
        y = HEIGHT-SIZE;
        color = Color.RED;
    }
    
    public Sphere(CanvasPanel canvas) {
        thread = new Thread(this);
        x = WIDTH/2-SIZE;
        y = HEIGHT-SIZE;
        color = Color.BLUE;
        this.canvas = canvas;
    }

    public Sphere(int x, int y) {
        thread = new Thread(this);
        this.x = x;
        this.y = y;
    }
    
    public Sphere(int _x, int _y, Color _color) {
        thread = new Thread(this);
        x = _x;
        y = _y;
        color = _color;
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
    
    public void move() throws InterruptedException {
        while(x < (WIDTH-SIZE) && (y > 0) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep(50);
            x += 10;
            y -= 10;
        }
        while( (x > 0) && (y < (HEIGHT-SIZE)) ) {
            paintComponent(canvas.getGraphics());
            Thread.sleep(50);
            x -= 10;
            y += 10;
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
