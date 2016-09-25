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

public class Logger
{
    private static Logger instance = new Logger();
    
    private Logger() {}
    
    public static Logger getInstance()
    {
        return instance;
    }
    
    public void log( String message )
    {
        System.out.println( message );
    }
}