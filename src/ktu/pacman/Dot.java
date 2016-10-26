/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Point;
import java.util.List;

/**
 *
 * @author Justinas
 */
public class Dot implements Food
{
    private GameMap map;
    private int value = 1;
    private List<Point> dots;

    Dot(GameMap map) {
        this.map = map;
        this.dots = this.findAllFood();
    }

    public int getValue()
    {
        return value;
    }
    
    public void setValue(int n)
    {
        value = n;
    }

    public List<Point> findAllFood()
    {
        return null;
    }
}
