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
public class RandomBehavior implements BehaviorAlgorithm
{
    public DirectionEnum move(GameMap map, Point currentPos, Point desiredPos)
    {
        if( currentPos.x < map.height()-2 )
            return DirectionEnum.BOTTOM;

        return DirectionEnum.UP;
    }
}
