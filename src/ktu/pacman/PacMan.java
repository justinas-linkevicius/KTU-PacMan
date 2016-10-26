/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Justinas
 */
public class PacMan
{
    public Point position;
    public GameMap map;
    public DirectionEnum direction;
    
    public PacMan(GameMap map)
    {
        this.map = map;
        this.findPacman();
        this.setDirection( DirectionEnum.NONE );
    }
    
    public void setDirection( DirectionEnum d )
    {
        this.direction = d;
    }
    
    public void findPacman()
    {
        boolean found = false;
        
        for(int i = 0; i < map.map.length; i++)
            for(int j = 0; j < map.map[0].length; j++)
                if(map.map[i][j] == '*')
                {
                    this.position = new Point(i,j);
                    found = true;
                }
                 
        if(!found)
            System.out.println("pacman not found in map string");
        else
            System.out.println("pacman found: " + this.position.x + "x" + this.position.y );
    }
    
    public int x()
    {
        return this.position.x;
    }
    
    public int y()
    {
        return this.position.y;
    }
    
    public void x(int x)
    {
        this.position.x = x;
    }
    
    public void y(int y)
    {
        this.position.y = y;
    }
    
    public void up()
    {
        this.map.set(position, ' ');
        
        if( this.map.get(position.x-1, position.y) != '1' ) 
            this.position.x--;
        
        this.map.set(position, '*');
    }
    
    public void down()
    {
        this.map.set(position, ' ');
        
        if( this.map.get(position.x+1, position.y) != '1' ) 
            this.position.x++;
        
        this.map.set(position, '*');
    }
    
    public void left()
    {
        this.map.set(position, ' ');
        if( this.map.get(position.x, position.y-1) != '1' ) 
            this.position.y--;
        this.map.set(position, '*');
    }
    
    public void right()
    {
        this.map.set(position, ' ');
        if( this.map.get(position.x, position.y+1) != '1' ) 
            this.position.y++;
        this.map.set(position, '*');
    }
    
    public MapPoint makeMapPoint()
    {
        return new MapPoint(this.position.x, this.position.y, Color.YELLOW);
    }
    
    public void update()
    {
        switch (direction)
        {
            case UP:
                this.up();
            break;
                    
            case RIGHT:
                this.right();
            break;
                
            case BOTTOM:
                this.down();
            break;
                
            case LEFT:
                this.left();
            break; 
        }
    }
}