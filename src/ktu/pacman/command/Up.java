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
public class Up extends IPacmanCommand {
    public Up(PacMan unitToControl) {
        super(unitToControl);
    }

    @Override
    public void move() {
        this.controllable.setDirection( DirectionEnum.UP );
    }
    
    @Override
    public void undo() {
        System.out.println("undoooooo");
        this.controllable.setDirection( DirectionEnum.BOTTOM );
    }    
}
