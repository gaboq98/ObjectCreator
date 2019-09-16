/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patterns;

public interface IObjectPool<T extends IPooledObject> {
    public T getObject() throws PoolException;
    public void releaceObject(T pooledObject);   
}
