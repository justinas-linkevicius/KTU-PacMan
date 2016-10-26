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
public abstract class MapElementFactory
{
    abstract Enemy getEnemy(String enemyType, GameMap map, Point pacmanPos);
    abstract Food getFood(String foodType, GameMap map);
}
