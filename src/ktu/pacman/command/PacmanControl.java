/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman.command;

import java.util.LinkedList;
import ktu.pacman.*;

/**
 *
 * @author Justinas
 */
public class PacmanControl
{
    private LinkedList<IPacmanCommand> commandsHistory = new LinkedList<IPacmanCommand>();

    public void moveLeft(PacMan unit)
    {
            IPacmanCommand cmd = new Left(unit);
            cmd.move();
            
            commandsHistory.add(cmd);
    }

    public void moveRight(PacMan unit)
    {
            IPacmanCommand cmd = new Right(unit);
            cmd.move();
            commandsHistory.add(cmd);
    }

    public void moveUp(PacMan unit)
    {
            IPacmanCommand cmd = new Up(unit);
            cmd.move();
            commandsHistory.add(cmd);
    }

    public void moveDown(PacMan unit)
    {
            IPacmanCommand cmd = new Down(unit);
            cmd.move();
            commandsHistory.add(cmd);		
    }

    public void undo()
    {
        if(commandsHistory.size() > 0)
        {
            System.out.println("undo control");
            IPacmanCommand cmd = commandsHistory.getLast();
            commandsHistory.removeLast();
            cmd.undo();
        }
    }    
}
