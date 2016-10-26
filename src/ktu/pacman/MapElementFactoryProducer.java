/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

/**
 *
 * @author Justinas
 */
public class MapElementFactoryProducer
{
    public static MapElementFactory getFactory(String choice)
    {
   
      if(choice.equalsIgnoreCase("ENEMY")){
         return new EnemyFactory();
         
      }else if(choice.equalsIgnoreCase("FOOD")){
         return new FoodFactory();
      }
      
      return null;
   }
}
