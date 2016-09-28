/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Justinas
 */
public class Sound {
    public Sound() {
        Settings settings = null;
        settings = settings.getInstance();
        if(settings.soundGet()) {
            try{
                AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(
                        this.getClass().getResource("./PacmanSoundEffect.mp3"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            catch(Exception ex)
            {
            }
        }
    }
}

