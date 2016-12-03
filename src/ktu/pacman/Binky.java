/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Point;
import ktu.pacman.collisionHandler.*;

/**
 *
 * @author Justinas
 */
public class Binky extends Enemy
{    
    public Binky(GameMap m, Point p, GameState g, CollisionHandler c)
    {
        super(m, p, g, c);
        
        enemyId = 'b';
        
        this.gameState.addEnemy(this);
        this.findPosition();
        
        System.out.println("Generated Binky");
    }
    
    public void setBehavior( BehaviorAlgorithm b )
    {
        this.behavior = b;
    }
    
    public Point getPosition()
    {
        return this.position;
    }
    
    public void setPosition(Point p)
    {
        this.position = p;
        
        // update map
    }
    
    public void update()
    {
        // get the new direction
        direction = this.behavior.move(map, position, pacmanPos);
           
        // check for collision
        this.collisionHandler.handle(this);
        
        if(!isFrozen())
        {
            if(previousChar == '\0')
                this.map.set(position, ' ');
            else
                this.map.set(position, previousChar);

            // new position after move
            this.position = Direction.directionToPoint(position, direction);

            // remember old symbol
            previousChar = this.map.get(position);
            if(previousChar == '*')
                previousChar = '\0';

            // set new position
            this.map.set(position, enemyId);            
        }

        if(isFrozen())
        {
            unfreeze();
        }
    }

    @Override
    public void findPosition()
    {
        boolean found = false;
        
        for(int i = 0; i < map.map.length; i++)
            for(int j = 0; j < map.map[0].length; j++)
                if(map.map[i][j] == enemyId)
                {
                    this.position = new Point(i,j);
                    found = true;
                }
          
        
        if(!found)
            System.out.println("Binky not found in map string");
        else
            System.out.println("Binky found: " + this.position.x + "x" + this.position.y );
        
    }

    @Override
    public void updateState() {
        System.out.println("Binky: updating state");
        
        if(gameState.getEnemyState() == 2)
        {
            this.behavior = new RandomBehavior2();
        }
    }
}
