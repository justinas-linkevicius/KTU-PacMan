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
public class MapPoint extends Point
{
    public Color  color;
    public String string = "";

    public MapPoint(int x, int y)
    {
        super(x, y);
    }
    
    public MapPoint(int x, int y, Color color)
    {
        super(x, y);
        this.color = color;
    }
    
    public MapPoint(int x, int y, Color color, String string)
    {
        super(x, y);
        this.color = color;
        this.string = string;
    }
}