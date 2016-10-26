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
public class Binky implements Enemy
{
    private GameMap map;
    private Point   pos;
    private Point   pacmanPos;
    private Direction previousDirection;
    
    private BehaviorAlgorithm behavior;
    
    public Binky(GameMap map, Point pacmanPos)
    {
        this.map = map;
        this.pacmanPos = pacmanPos;
        this.findPosition();
        
        System.out.println("Generated Binky");
    }
    
    public void setBehavior( BehaviorAlgorithm b )
    {
        this.behavior = b;
    }
    
    public Point getPosition()
    {
        return this.pos;
    }
    
    public void setPosition(Point p)
    {
        this.pos = p;
        
        // update map
    }
    
    public void update()
    {
        DirectionEnum direction = this.behavior.move(map, pos, pos);
        
        // update map
        this.map.set(pos, ' ');
        this.pos = Direction.directionToPoint(pos, direction);
        this.map.set(pos, 'b');
    }

    @Override
    public void findPosition()
    {
        boolean found = false;
        
        for(int i = 0; i < map.map.length; i++)
            for(int j = 0; j < map.map[0].length; j++)
                if(map.map[i][j] == 'b')
                {
                    this.pos = new Point(i,j);
                    found = true;
                }
                 
        if(!found)
            System.out.println("Binky not found in map string");
        else
            System.out.println("Binky found: " + this.pos.x + "x" + this.pos.y );
    }
}
