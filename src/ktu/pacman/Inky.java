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
public class Inky implements Enemy
{
    private GameMap map;
    private Point   pos;
    private Point   pacmanPos;
    
    private BehaviorAlgorithm behavior;
    
    public Inky(GameMap map, Point pacmanPos)
    {
        this.map = map;
        this.pacmanPos = pacmanPos;
        
        System.out.println("Generated Inky");
    }
    
    public void setBehavior( BehaviorAlgorithm b )
    {
        this.behavior = b;
    }
    
    public void setPosition(Point p)
    {
        this.pos = p;
        
        // update map
    }
    
    public Point getPosition()
    {
        return this.pos;
    }
    
    public void update()
    {
        this.behavior.move(map, pos, pos);
    }

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
            System.out.println("Inky not found in map string");
        else
            System.out.println("Inky found: " + this.pos.x + "x" + this.pos.y );
    }
}