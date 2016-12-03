/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Point;
import ktu.pacman.behaviors.bfs.BFSBehavior;

/**
 *
 * @author Justinas
 */
public class SlowBFSBehavior implements BehaviorAlgorithm
{
    public DirectionEnum move(GameMap map, Point currentPos, Point desiredPos)
    {
        BFSBehavior bfs = new BFSBehavior();
        DirectionEnum bfsDirection = bfs.move(map, currentPos, desiredPos);
        
        // random slow down
        int randomNum = 1 + (int)(Math.random() * 10); 
        if(randomNum < 5)
            bfsDirection = DirectionEnum.NONE;
        
        return bfsDirection;
    }
}