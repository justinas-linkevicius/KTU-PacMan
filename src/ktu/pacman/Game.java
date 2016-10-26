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
        LogFactory logFactory = new LogFactory();
        
        ILogger consoleLogger = logFactory.getLogger("consoleLogger");
        
        consoleLogger.log("test");
        
        ILogger fl = logFactory.getLogger("fileLogger");
        
        fl.log("testFile");
        
        ConsoleLogger.getInstance().log("game starting");
        
        /*
        Window window = new Window();
        window.setVisible(true);
        */

        Sound sound = new Sound();
        
        GameFrame glt = new GameFrame();
        glt.setVisible(true);
    }
}
