/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Justinas
 */
public class PacMan
{
    public Point position;

    public PacMan(int x, int y) {
        this.position = new Point(x, y);
    }
    
    public int x()
    {
        return this.position.x;
    }
    
    public int y()
    {
        return this.position.y;
    }
    
    public void x(int x)
    {
        this.position.x = x;
    }
    
    public void y(int y)
    {
        this.position.y = y;
    }
    
    public void up()
    {
        this.position.y--;
    }
    
    public void down()
    {
        this.position.y++;
    }
    
    public void left()
    {
        this.position.x--;
    }
    
    public void right()
    {
        this.position.x++;
    }
    
    public MapPoint makeMapPoint()
    {
        return new MapPoint(this.position.x, this.position.y, Color.YELLOW);
    }
}