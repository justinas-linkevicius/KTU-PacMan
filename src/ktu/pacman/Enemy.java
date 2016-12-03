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
public abstract class Enemy
{
    protected GameMap map;
    
    // current enemy position & last direction
    protected Point   position;
    protected DirectionEnum direction = DirectionEnum.NONE;
    
    protected Point   pacmanPos;
    
    protected char previousChar = '\0';
    protected CollisionHandler collisionHandler;
    
    // strategy
    protected BehaviorAlgorithm behavior;
  
    // observer
    protected GameState gameState;
    public abstract void updateState();

        
    public Enemy(GameMap m, Point p, GameState g, CollisionHandler c)
    {
        this.gameState = g;
        this.map       = m;
        this.pacmanPos = p;
        this.collisionHandler = c;
        
        this.findPosition();       
    }
    
    public abstract void findPosition();
    public abstract Point getPosition();
    public abstract void setPosition(Point p);
    public abstract void setBehavior( BehaviorAlgorithm b );
    public abstract void update();
    
    // what element of the map pacman will see after moving 1 step in current direction
    public char nextElement()
    {
        return this.map.get(position, direction);
    }
}