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
public interface BehaviorAlgorithm
{
    public DirectionEnum move(IGameMap map, Point currentPos, Point desiredPos);
}
