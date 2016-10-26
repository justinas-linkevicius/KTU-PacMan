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

enum DirectionEnum {
        UP, UPRIGHT, RIGHT, BOTTOMRIGHT, BOTTOM, BOTTOMLEFT, LEFT, TOPLEFT
}

// -1:-1 0:-1 1:-1 1:0 1:1 0:1 -1:1 -1:0
public class Direction {
    public int x;
    public int y;
    
    private Direction(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public static Direction random()
    {
        return new Direction(0,0);
    }
    
    public static Point directionToPoint( Point p, DirectionEnum d )
    {
        switch (d)
        {
            case UP:
                p.x--;
            break;
                    
            case UPRIGHT:
                p.x--;
                p.y++;
            break;
                
            case BOTTOMRIGHT:
                p.x++;
                p.y++;
            break;
                
            case BOTTOM:
                p.x++;
            break;
                
            case BOTTOMLEFT:
                p.x++;
                p.y--;
            break;                
                
            case LEFT:
                p.y--;
            break; 

            case TOPLEFT:
                p.x--;
                p.y--;
            break;
        }
        
        return p;
    }
}
