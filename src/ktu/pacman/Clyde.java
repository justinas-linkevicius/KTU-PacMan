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
public class Clyde implements Enemy
{
    private GameMap map;
    private Point   pos;
    private Point   pacmanPos;
    
    private BehaviorAlgorithm behavior;
    
    public Clyde(GameMap map, Point pacmanPos)
    {
        this.map = map;
        this.pacmanPos = pacmanPos;
        
        System.out.println("Generated Clyde");
        this.findPosition();
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
        DirectionEnum direction = this.behavior.move(map, pos, pos);
        
        // update map
        this.map.set(pos, ' ');
        this.pos = Direction.directionToPoint(pos, direction);
        this.map.set(pos, 'c');
    }

    @Override
    public void findPosition()
    {
        boolean found = false;
        
        for(int i = 0; i < map.map.length; i++)
            for(int j = 0; j < map.map[0].length; j++)
                if(map.map[i][j] == 'c')
                {
                    this.pos = new Point(i,j);
                    found = true;
                }
                 
        if(!found)
            System.out.println("Clyde not found in map string");
        else
            System.out.println("Clyde found: " + this.pos.x + "x" + this.pos.y );
    }
}
