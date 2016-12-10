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
    public DirectionEnum move(IGameMap map, Point currentPos, Point desiredPos)
    {
        
        int randomDirectionNum; 
        DirectionEnum randomDirection = DirectionEnum.NONE;
        
        boolean freeDirectionFound = false;
        
        while(freeDirectionFound == false)
        {
             randomDirectionNum = 1 + (int) (Math.random() * 4);
             
             switch(randomDirectionNum)
             {
                case 1:
                    randomDirection = DirectionEnum.BOTTOM;
                break;

                case 2:
                    randomDirection = DirectionEnum.UP;
                break;

                case 3:
                    randomDirection = DirectionEnum.LEFT;
                break;

                case 4:
                    randomDirection = DirectionEnum.RIGHT;
                break;

                default:
                    randomDirection = DirectionEnum.NONE;
                break;
             }
        
            if( map.get(currentPos, randomDirection) != '1' )
                freeDirectionFound = true;
        }
        
        return randomDirection;
    }
}
