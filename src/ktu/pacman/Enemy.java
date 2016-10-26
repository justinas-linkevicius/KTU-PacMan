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
public interface Enemy
{
    public void findPosition();
    public Point getPosition();
    public void setPosition(Point p);
    public void setBehavior( BehaviorAlgorithm b );
    public void update();
}
