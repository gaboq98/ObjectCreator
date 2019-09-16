/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import GUI.CanvasPanel;
import Model.Sphere;
import java.awt.Color;

/**
 *
 * @author Gabriel
 */
public interface ISphereFactory {
    
    public Sphere createNew(CanvasPanel canvas, Color color,  String direction, int speed);
    
}
