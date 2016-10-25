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
public class GameMap
{
    public char map[][];

    public GameMap( String[] map )
    {
        this.map = new char[map.length][map[0].length()];
        
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[0].length(); j++)
            {
                this.map[i][j] = map[i].charAt(j);
            }
    }
    
    public char get(int x, int y)
    {
        return this.map[x][y];
    }
    
    public void set(Point p, char s)
    {
        this.map[ p.x ][ p.y ] = s;
    }
    
    public int width()
    {
        return this.map[0].length;
    }
    
    public int height()
    {
        return this.map.length;
    }
}
