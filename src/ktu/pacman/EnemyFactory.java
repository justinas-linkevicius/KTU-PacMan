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
public class EnemyFactory extends MapElementFactory
{
    @Override
    public Enemy getEnemy(String enemyType, GameMap map, Point pacmanPos)
    {
         if(enemyType == null){
            return null;
         }		

         if(enemyType.equalsIgnoreCase("Binky"))
         {
            return new Binky(map, pacmanPos);

         } else if(enemyType.equalsIgnoreCase("Clyde"))
         {
            return new Clyde(map, pacmanPos);

         } else if(enemyType.equalsIgnoreCase("Inky"))
         {
            return new Inky(map, pacmanPos);
            
         } else if(enemyType.equalsIgnoreCase("Pinky"))
         {
            return new Pinky(map, pacmanPos);
         }

         return null;
    }

    @Override
    Food getFood(String foodType, GameMap map)
    {
        return null;
    }
}
