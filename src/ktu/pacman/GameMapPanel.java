/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Justinas
 */
public class GameMapPanel extends JPanel implements KeyEventDispatcher
{
    private PacMan pacman;
    
    private GameMap map;
   
    //private String[] map;
    
      private int cellWidth  = 20;
      private int cellHeight = 20;
      
      private Point testMovingPos = new Point(10, 40);
           
      private java.util.List<Point> fillCells;
      
      private java.util.List<MapPoint> cells;
      
      public GameMapPanel()
      {
        //addKeyListener(this);
        //fillCells = new ArrayList<>(25);
        
        this.map = new GameMap(new String[]
        { 
            "111111111111111111111111111111111111111",
            "1                                     1",
            "1         pb                          1",
            "1         ci                          1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1            11111111111111111111111111",
            "1            1                        1",
            "1            1          1             1",
            "1                       1             1",
            "1111111111111111111111111             1",
            "1                                     1",
            "1          1                          1",
            "1          1                          11",
            "1          1111111111111111111111111111",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1         ..                          1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                                     1",
            "1                 *                   1",
            "1                                     1",
            "1                                     1",
            "1       .                .            1",
            "1                                     1",
            "1     .                               1",
            "1                                     1",
            "111111111111111111111111111111111111111"
        });
        
        this.cells = new ArrayList<MapPoint>();
 
        System.out.println("map size: " +  map.width() + "x" +  map.height() );
        
        this.pacman = new PacMan(this.map);
        
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);
      }
      
      @Override
      public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {

            int keyCode = e.getKeyCode();
        
            switch( keyCode ) { 
                case KeyEvent.VK_UP:
                    // handle up 
                    pacman.up();
                    //cells.add( pacman.makeMapPoint() );
                break;
                case KeyEvent.VK_DOWN:
                    // handle down 
                    pacman.down();
                    //cells.add( pacman.makeMapPoint() );
                break;
                case KeyEvent.VK_LEFT:
                    // handle left
                    pacman.left();
                    //cells.add( pacman.makeMapPoint() );
                break;
                case KeyEvent.VK_RIGHT:
                    // handle right
                    pacman.right();
                    //cells.add( pacman.makeMapPoint() );
                break;
             }

            System.out.println("keyPressed();");
            
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            
        } else if (e.getID() == KeyEvent.KEY_TYPED) {
            
        }
        return false;
      }
      
      public void update() 
      {
        System.out.println("Updating Game");
          
        cells.clear();
        for(int i = 0; i < map.height(); i++)
            for(int j = 0; j < map.width(); j++)
            {
                // walls
                if(map.get(i,j) == '1')
                {
                    cells.add( new MapPoint(j, i, Color.BLACK ) );
                }
                
                // pacman
                if(map.get(i,j) == '*')
                {
                    cells.add( new MapPoint(j, i, Color.YELLOW ) );
                }
                
                // enemies
                if(map.get(i,j) == 'p')
                {
                    cells.add( new MapPoint(j, i, Color.PINK ) );
                }
                if(map.get(i,j) == 'b')
                {
                    cells.add( new MapPoint(j, i, Color.RED ) );
                }
                if(map.get(i,j) == 'i')
                {
                    cells.add( new MapPoint(j, i, Color.CYAN ) );
                }
                if(map.get(i,j) == 'c')
                {
                    cells.add( new MapPoint(j, i, Color.ORANGE ) );
                }
                
                // power pellets
                if(map.get(i,j) == '.')
                {
                    cells.add( new MapPoint(j, i, Color.GREEN, "■" ) );
                }
            }
      }
      
      public void fillCell(int x, int y) {
          
        //fillCells.add( new Point(x, y) );
          
         //cells.add( new MapPoint(x, y) );
        
        // repaint calls paintComponent();
        // repaint();
     }
      
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);
         
         g.setColor(getBackground());
         
        /*
        for (Point fillCell : fillCells)
        {
            
            int cellX = 10 + (fillCell.x * cellWidth);
            int cellY = 10 + (fillCell.y * cellHeight);
            
            g.setColor(Color.RED);
            g.fillRect(cellX, cellY, cellWidth, cellHeight);
        }
         */
        
        for (MapPoint cell : cells)
        {
            int cellX = 10 + (cell.x * cellWidth);
            int cellY = 10 + (cell.y * cellHeight);
            
            g.setColor(cell.color);
            
            if(!cell.string.isEmpty())
            {
                g.setFont( new Font("Serif", Font.BOLD, 12) );
                g.drawString(cell.string, cellX, cellY);
                
                continue;
            }
            
            g.fillRect(cellX, cellY, cellWidth, cellHeight);
        }
        
        g.setColor(Color.RED);
       
        /*
        * @param         x   the <i>x</i> coordinate
        *                         of the rectangle to be drawn.
        * @param         y   the <i>y</i> coordinate
        *                         of the rectangle to be drawn.
        * @param         width   the width of the rectangle to be drawn.
        * @param         height   the height of the rectangle to be drawn.
        */
        
        //g.drawRect(10, 10, 800, 500);
        
        /*
        Random rand = new Random();
        int randomX = 0 + rand.nextInt((500 - 0) + 1);
        int randomY = 0 + rand.nextInt((500 - 0) + 1);
        */
         //g.drawRect(this.cellWidth, this.cellHeight, randomX, randomY);
        
        
         //g.drawString("*", 50, 50);

         //fps counter
         //g.setColor(Color.BLACK);
         //g.drawString("FPS: " + fps, 10, 10);
         //frameCount++
      }
   }