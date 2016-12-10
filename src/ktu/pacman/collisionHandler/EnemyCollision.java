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
        //System.out.println( enemy.enemyId + " collides with '" + enemy.nextElement() + "'");
        
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
            char collisionWith = this.findCollisionElement();
            
            switch(collisionWith)
            {
                // freeze when colliding with other enemies
                case 'b': 
                case 'c':
                case 'i':
                case 'p':
                    enemy.freeze();
                break;
                
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
                    enemy.freeze();
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
            this.enemy = (Enemy) o;
            this.handleCollision();
        } else
        {
            this.next.handle(o);
        }
    }
}
