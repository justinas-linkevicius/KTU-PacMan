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
public class EnemyFactory extends MapElementFactory
{
    @Override
    public Enemy getEnemy(String enemyType, IGameMap map, Point pacmanPos, IGameState gameState, CollisionHandler collisionHandler)
    {
         if(enemyType == null){
            return null;
         }		

         if(enemyType.equalsIgnoreCase("Binky"))
         {
            return new Binky(map, pacmanPos, gameState, collisionHandler);

         } else if(enemyType.equalsIgnoreCase("Clyde"))
         {
            return new Clyde(map, pacmanPos, gameState, collisionHandler);

         } else if(enemyType.equalsIgnoreCase("Inky"))
         {
            return new Inky(map, pacmanPos, gameState, collisionHandler);
            
         } else if(enemyType.equalsIgnoreCase("Pinky"))
         {
            return new Pinky(map, pacmanPos, gameState, collisionHandler);
         }

         return null;
    }

    @Override 
    Food getFood(String foodType, IGameMap map)
    {
        return null;
    }
}
