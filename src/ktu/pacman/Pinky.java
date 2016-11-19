/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Point;

/**
 *
 * @author Justinas
 */
public class Pinky extends Enemy
{
    public Pinky(GameMap m, Point p, GameState g)
    {
        super(m, p, g);
        this.gameState.addEnemy(this);
        
        System.out.println("Generated Pinky");
    }
    
    public void setBehavior( BehaviorAlgorithm b )
    {
        this.behavior = b;
    }
    
    public void setPosition(Point p)
    {
        this.pos = p;
    }
    
    public Point getPosition()
    {
        return this.pos;
    }
    
    public void update()
    {
        this.behavior.move(map, pos, pos);
    }

    @Override
    public void findPosition()
    {
        boolean found = false;
        
        for(int i = 0; i < map.map.length; i++)
            for(int j = 0; j < map.map[0].length; j++)
                if(map.map[i][j] == 'i')
                {
                    this.pos = new Point(i,j);
                    found = true;
                }
                 
        if(!found)
            System.out.println("Pinky not found in map string");
        else
            System.out.println("Pinky found: " + this.pos.x + "x" + this.pos.y );
    }

    @Override
    public void updateState() {
        System.out.println("Pinky: updatingState()");
    }
}
