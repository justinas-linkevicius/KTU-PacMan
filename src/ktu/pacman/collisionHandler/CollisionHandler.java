/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman.collisionHandler;

/**
 *
 * @author Justinas
 */
public abstract class CollisionHandler
{
    protected CollisionHandler next;
    
    public void setNext(CollisionHandler next)
    {
        this.next = next;
    }
    
    public abstract void handle(Object o);
}
