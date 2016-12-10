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
public class WawPlayer implements AdvancedMediaPlayer{
   @Override
   public void playWaw(String fileName) {
      System.out.println("Playing waw file. Name: "+ fileName);		
   }

   @Override
   public void playMp3(String fileName) {
      //do nothing
   }
}
