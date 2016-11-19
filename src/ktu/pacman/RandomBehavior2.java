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
public class RandomBehavior2 implements BehaviorAlgorithm
{
    // TODO: add Point previousPos
    public DirectionEnum move(GameMap map, Point currentPos, Point desiredPos)
    {
        if( map.get(currentPos, DirectionEnum.UP) != '1')
            return DirectionEnum.UP;

        return DirectionEnum.BOTTOM;
    }
}
