/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

/**
 *
 * @author Danielius
 */
public class Settings {
    private static Settings instance = null;
    
    private Settings() {}
    private static Boolean sound;
    private static int[] sizeXY = new int[2];
    
    public static Settings getInstance()
    {
        if(instance == null) {
            instance = new Settings();
        }
        return instance;
    }
    
    public void soundSet ( Boolean soundB )
    {
        sound = soundB;
    }
    
    public Boolean soundGet ()
    {
        return sound;
    }
    
    public void sizeSet ( int[] sizeA )
    {
        sizeXY = sizeA;
    }
    
    public int[] sizeGet ()
    {
        return sizeXY;
    }
}
