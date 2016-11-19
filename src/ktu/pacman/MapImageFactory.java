/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.util.Hashtable;

/**
 *
 * @author Justinas
 */
public class MapImageFactory
{
    private final static Hashtable<String, IMapImage> hash = new Hashtable<String, IMapImage>();

    public static IMapImage getImage(String imageType, String imagePath)
    {
            IMapImage image = (IMapImage) hash.get(imagePath);

            if(image == null)
            {
                if(imageType.equalsIgnoreCase("pacmanImage"))
                    image = new PacmanImage(imagePath);

                hash.put(imagePath, image);
            }
            
            return image;
    }    
}
