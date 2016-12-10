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
public abstract class IGameMap
{
    public char map[][];
    
    public abstract char get(int x, int y);
    
    public abstract char get(Point p);
    
    public abstract char get(Point p, DirectionEnum d);
    
    public abstract void set(Point p, char s);
    
    public abstract void set(int x, int y, char s);
    
    public abstract int width();
    
    public abstract int height();
}
