/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//import jaco.mp3.player.MP3Player;
//import java.io.File;
/**
 *
 * @author Justinas
 */
public class Sound {
    public Sound() {
        Settings settings = null;
        settings = settings.getInstance();
        if(settings.soundGet()) {
            Logger.getInstance().log("SOUND ON");
            //new MP3Player(new File("PacmanSoundEffect.mp3")).play();   
                //MP3Player player = new MP3Player(new File("Pacman.mp3"));
                //player.play();
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //frame.getContentPane().add(player);
                //frame.pack();
        }
    }
}

