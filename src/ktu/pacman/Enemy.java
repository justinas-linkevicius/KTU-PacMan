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
abstract class Enemy
{
    protected GameMap map;
    protected Point   pos;
    protected Point   pacmanPos;
    protected DirectionEnum previousDirection = DirectionEnum.NONE;
    protected char previousChar = '\0';
    
    // strategy
    protected BehaviorAlgorithm behavior;
  
    // observer
    protected GameState gameState;
    public abstract void updateState();
    
    public Enemy(GameMap m, Point p, GameState g)
    {
        this.gameState = g;
        this.map       = m;
        this.pacmanPos = p;
        
        this.findPosition();       
    }
    
    public abstract void findPosition();
    public abstract Point getPosition();
    public abstract void setPosition(Point p);
    public abstract void setBehavior( BehaviorAlgorithm b );
    public abstract void update();
}