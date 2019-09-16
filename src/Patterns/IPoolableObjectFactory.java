/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import GUI.CanvasPanel;
import java.awt.Color;

public interface IPoolableObjectFactory<T extends IPooledObject> {
    public T createNew(CanvasPanel canvas, Color color, String direction, int speed);
}



