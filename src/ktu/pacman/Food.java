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
public interface Food
{
    public int getValue();
    public void setValue(int n);
    public List<Point> findAllFood();
}
