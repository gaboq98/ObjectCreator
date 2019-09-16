/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

import Model.Sphere;

/**
 *
 * @author Pumkin
 */
public class SpherePool extends AbstractObjectPool<Sphere>{
    public SpherePool(int minInstances, int maxInstances, int waitTime,
            IPoolableObjectFactory<SpherePool> poolableObjectFactory) {
        super(minInstances, maxInstances, waitTime, poolableObjectFactory);
    }
}

