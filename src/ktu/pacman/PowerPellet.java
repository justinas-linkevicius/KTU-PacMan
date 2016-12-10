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
public class PowerPellet implements Food
{
    private IGameMap map;
    private int value = 10;
    private List<Point> powerpellets;
    
    PowerPellet(IGameMap map) {
        this.map = map;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public void setValue(int n)
    {
        value = n;
    }

    public List<Point> findAllFood() {
        return null;
    }
}
