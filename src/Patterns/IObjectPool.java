/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import Model.Sphere;

public interface IObjectPool<T extends IObjectPool> {
    
    public Sphere getObject();
    public void releaseObject(Sphere sphere);   
    
}
