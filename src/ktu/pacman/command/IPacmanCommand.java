/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman.command;

import ktu.pacman.*;

/**
 *
 * @author Justinas
 */

public abstract class IPacmanCommand
{
    public PacMan controllable;

    public IPacmanCommand(PacMan unitToControl)
    {
        controllable = unitToControl;
    }

    public abstract void move();
    public abstract void undo();
}