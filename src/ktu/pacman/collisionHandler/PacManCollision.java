/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman.collisionHandler;

import ktu.pacman.PacMan;

/**
 *
 * @author Justinas
 */
public class PacManCollision extends CollisionHandler
{
    private String collisionElements = ".$bpic";
    private PacMan pacman;

    public boolean isColision()
    {
        // pacman.nextElement() 
        for(int i = 0; i < collisionElements.length(); i++)
            if( pacman.nextElement() == collisionElements.charAt(i) )
                return true;
        
        return false;
    }
    
    public char findCollisionElement()
    {
        for(int i = 0; i < collisionElements.length(); i++)
            if( pacman.nextElement() == collisionElements.charAt(i) )
                return pacman.nextElement();
        
        return ' ';
    }
    
    public void handleCollision()
    {
        if( this.isColision() )
        {
            char collisionWith = this.findCollisionElement();
            
            switch(collisionWith)
            {
                // collision with food: .$
                case '.':
                    System.out.println("Got food .");
                break;
                    
                case '$':
                    System.out.println("Got food $");
                    
                    pacman.gameState.setEnemyState(2);
                break;
                    
                // collision with enemies: bpic
                case 'b':
                    System.out.println("Game over");
                break; 
                    
                case 'p':
                    System.out.println("Game over");
                break; 
                    
                case 'i':
                    System.out.println("Game over");
                break;
                    
                case 'c':
                    System.out.println("Game over");
                break;
            }
        }
    }

    @Override
    public void handle(Object o)
    {
        // handle pacman
        if(o.getClass().getName() == "ktu.pacman.PacMan")
        {
            this.pacman = (PacMan) o;
            this.handleCollision();
        } else
        {
            this.next.handle(o);
        }
    }
}
