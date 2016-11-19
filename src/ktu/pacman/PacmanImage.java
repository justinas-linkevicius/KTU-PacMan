/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Justinas
 */
class PacmanImage implements IMapImage
{
    BufferedImage image;

    public PacmanImage(String imagePath)
    {
        try {
            File imageFile = new File(imagePath);	
            image = ImageIO.read(imageFile );					
        } catch (IOException e1) {
            e1.printStackTrace();
        }			
    }

    @Override
    public void draw(Graphics g, int x, int y, GameMapPanel p)
    {
        g.drawImage(image, x, y, p);
    }
}
