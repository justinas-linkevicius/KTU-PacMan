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
public class FoodFactory extends MapElementFactory
{
    @Override
    Food getFood(String foodType, GameMap map)
    {
         if(foodType == null){
            return null;
         }		

         if(foodType.equalsIgnoreCase("Dot")){
            return new Dot(map);

         } else if(foodType.equalsIgnoreCase("PowerPellet")){
            return new PowerPellet(map);
         }

         return null;        
    }

    @Override
    Enemy getEnemy(String enemyType, GameMap map, Point pacmanPos, GameState gameState, CollisionHandler collisionHandler) {
        return null;
    }
}
