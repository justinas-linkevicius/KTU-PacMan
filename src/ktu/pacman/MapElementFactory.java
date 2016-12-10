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
public abstract class MapElementFactory
{
    abstract Enemy getEnemy(String enemyType, IGameMap map, Point pacmanPos, IGameState gameState, CollisionHandler collisionHandler);
    abstract Food getFood(String foodType, IGameMap map);
}
 