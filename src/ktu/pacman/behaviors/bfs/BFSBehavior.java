/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman.behaviors.bfs;

/**
 *
 * @author Justinas
 */
import java.awt.Point;
import ktu.pacman.BehaviorAlgorithm;
import ktu.pacman.DirectionEnum;
import ktu.pacman.GameMap;

public class BFSBehavior implements BehaviorAlgorithm
{
    public DirectionEnum move(GameMap map, Point currentPos, Point desiredPos)
    {
        PathFinder bfsPathFinder = new PathFinder( map.map, currentPos, desiredPos );  
        
        /*
        System.out.println(  );
        System.out.println("currentPos: " + currentPos + ":" + map.get(currentPos));
        System.out.println("desiredPos: " + desiredPos);
        */
        
        if( bfsPathFinder.solve() )
        {
            return bfsPathFinder.getFirstMove();
        }
        
        return DirectionEnum.NONE;
    }
}