/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

/**
 *
 * @author LtDanis
 */
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileLogger implements ILogger
{
    private static FileLogger instance = new FileLogger();
    
    private FileLogger() {}
    
    public static FileLogger getInstance()
    {
        return instance;
    }
    
    public void log( String message )
    {
        BufferedWriter pw = null;
        try {
            pw = new BufferedWriter(new FileWriter("log.txt", true));
            pw.write(message + "\n");
            pw.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}