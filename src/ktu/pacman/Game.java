/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

/**
 *
 * @author Justinas
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {   
        Logger.getInstance().log("game starting");
        /*
        Window window = new Window();
        window.setVisible(true);
        */

        GameFrame glt = new GameFrame();
        glt.setVisible(true);
    }
}
