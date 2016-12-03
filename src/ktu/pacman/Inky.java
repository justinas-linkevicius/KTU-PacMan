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
public class Inky extends Enemy
{
    public Inky(GameMap m, Point p, GameState g,  CollisionHandler c)
    {
        super(m, p, g, c);
        this.gameState.addEnemy(this);
        
        System.out.println("Generated Inky");
    }
    
    public void setBehavior( BehaviorAlgorithm b )
    {
        this.behavior = b;
    }
    
    public void setPosition(Point p)
    {
        this.position = p;
        
        // update map
    }
    
    public Point getPosition()
    {
        return this.position;
    }
    
    public void update()
    {
        this.findPosition();
        
        DirectionEnum direction = this.behavior.move(map, position, pacmanPos);
        
        // update map
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
        this.map.set(position, 'i');
    }

    public void findPosition()
    {
        boolean found = false;
        
        for(int i = 0; i < map.map.length; i++)
            for(int j = 0; j < map.map[0].length; j++)
                if(map.map[i][j] == 'i')
                {
                    this.position = new Point(i,j);
                    found = true;
                }
                 
        if(!found)
            System.out.println("Inky not found in map string");
        else
            System.out.println("Inky found: " + this.position.x + "x" + this.position.y );
    }

    @Override
    public void updateState() {
        System.out.println("Inky: updatingState()");
    }
}
