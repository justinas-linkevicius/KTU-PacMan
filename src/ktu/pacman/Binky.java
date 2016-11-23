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
public class Binky extends Enemy
{
    private String collisionElements = "1pic";
    
    public Binky(GameMap m, Point p, GameState g)
    {
        super(m, p, g);
        this.gameState.addEnemy(this);
        
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
        this.findPosition();
        
        DirectionEnum direction = this.behavior.move(map, pos, pacmanPos);
        
        // slow down
        int randomNum = 1 + (int)(Math.random() * 10); 
        if(randomNum < 4)
        {
            direction = DirectionEnum.NONE;
        }
        
        // check for collision
        boolean isCollision = false;
        for(int i = 0; i < collisionElements.length(); i++)
            if( this.map.get(pos, direction) == collisionElements.charAt(i) )
                isCollision = true;
        
        if(isCollision)
        {
            direction = DirectionEnum.NONE;
        }
        
        // update map
        if(previousChar == '\0')
            this.map.set(pos, ' ');
        else
            this.map.set(pos, previousChar);
        
        // new position after move
        this.pos = Direction.directionToPoint(pos, direction);
        
        // remember old symbol
        previousChar = this.map.get(pos);
        if(previousChar == '*')
            previousChar = '\0';
        
        // set new position
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
          
        /*
        if(!found)
            System.out.println("Binky not found in map string");
        else
            System.out.println("Binky found: " + this.pos.x + "x" + this.pos.y );
        */
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
