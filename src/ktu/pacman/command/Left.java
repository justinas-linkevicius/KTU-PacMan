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
public class Left extends IPacmanCommand {
    public Left(PacMan unitToControl) {
        super(unitToControl);
    }

    @Override
    public void move() {
        this.controllable.setDirection( DirectionEnum.LEFT );
    }
    
    @Override
    public void undo() {
        this.controllable.setDirection( DirectionEnum.RIGHT );
    }
}
