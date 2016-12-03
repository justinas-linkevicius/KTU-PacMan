/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman.collisionHandler;

import ktu.pacman.Enemy;

/**
 *
 * @author Justinas
 */

public class EnemyCollision extends CollisionHandler
{
    private Enemy enemy;
    private String collisionElements = "1bpic.*$";
    
    public boolean isColision()
    {
        System.out.println( enemy.nextElement() );
        
        for(int i = 0; i < collisionElements.length(); i++)
            if( enemy.nextElement() == collisionElements.charAt(i) )
                return true;
        
        return false;
    }
    
    public char findCollisionElement()
    {
        for(int i = 0; i < collisionElements.length(); i++)
            if( enemy.nextElement() == collisionElements.charAt(i) )
                return enemy.nextElement();
        
        return ' ';
    }
    
    public void handleCollision()
    {
        if( this.isColision() )
        {
            System.out.println("COLLISION!");
            
            char collisionWith = this.findCollisionElement();
            
            switch(collisionWith)
            {
                // collision with food: .$
                case '.':
                    System.out.println("Enemy collision with food .");
                break;
                    
                case '$':
                    System.out.println("Enemy collision with food $");
                break;
                    
                // collision with pacman: *
                case '*':
                    System.out.println("Enemy collision with PacMan: Gave Over");
                break;
            }
        }
    }

    @Override
    public void handle(Object o)
    {
        // handle all enemy objects
        if(o.getClass().getSuperclass().getName()  == "ktu.pacman.Enemy")
        {
            //System.out.println("Handling Enemy: " + o.getClass().getName());
            this.enemy = (Enemy) o;
            this.handleCollision();
        } else if(this.next != null)
        {
            this.next.handle(o);
        }
    }
}
