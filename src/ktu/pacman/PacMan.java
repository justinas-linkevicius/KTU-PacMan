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
    private GameMap map;
    private GameState gameState;
    private DirectionEnum direction;
    private String collisionElements = ".$bpic";
    
    public PacMan(GameMap map, GameState gameState)
    {
        this.gameState = gameState;
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
    
    // check for walls & enemies
    public boolean canMove( DirectionEnum d )
    {
        String cantMove = "1bpic";
        
        for(int i = 0; i < cantMove.length(); i++)
            if( this.map.get(position, d) == cantMove.charAt(i) )
                return false;
        
        return true;
    }

    public boolean isColision()
    {
        for(int i = 0; i < collisionElements.length(); i++)
            if( this.map.get(position, direction) == collisionElements.charAt(i) )
                return true;
        
        return false;
    }
    
    public char findCollisionElement()
    {
        for(int i = 0; i < collisionElements.length(); i++)
            if( this.map.get(position, direction) == collisionElements.charAt(i) )
                return this.map.get(position, direction);
        
        return ' ';
    }
    
    public void onCollision()
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
                    gameState.setEnemyState(2);
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
    
    public void up()
    {
        this.map.set(position, ' ');
        this.position.x--;
        this.map.set(position, '*');           
    }
    
    public void down()
    {
        this.map.set(position, ' ');
        this.position.x++;
        this.map.set(position, '*');
    }
    
    public void left()
    {
        this.map.set(position, ' ');
        this.position.y--;
        this.map.set(position, '*');
    }
    
    public void right()
    {
        this.map.set(position, ' ');
        this.position.y++;
        this.map.set(position, '*');
    }
    
    public MapPoint makeMapPoint()
    {
        return new MapPoint(this.position.x, this.position.y, Color.YELLOW);
    }
    
    public void update()
    {
        this.onCollision();
        
        switch (direction)
        {
            case UP:
                if(this.canMove(DirectionEnum.UP) )
                    this.up();
            break;
                    
            case RIGHT:
                if(this.canMove(DirectionEnum.RIGHT) )
                    this.right();
            break;
                
            case BOTTOM:
                if(this.canMove(DirectionEnum.BOTTOM) )
                    this.down();
            break;
                
            case LEFT:
                if(this.canMove(DirectionEnum.LEFT) )
                    this.left();
            break; 
        }
    }
}