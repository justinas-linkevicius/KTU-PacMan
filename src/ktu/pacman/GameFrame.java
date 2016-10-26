/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Justinas
 */
public class GameFrame extends JFrame implements ActionListener
{
   private JPanel       topPanel     = new JPanel();
   private GameMapPanel gamePanel    = new GameMapPanel();
   private JPanel       buttonsPanel = new JPanel();
   
   private JButton startButton = new JButton("Start");
   private JButton quitButton  = new JButton("Quit");
   private JButton pauseButton = new JButton("Pause");
   
   private boolean running = false;
   private boolean paused  = false;
   
   // TODO: fix fps
   private int fps = 60;
   private int frameCount = 0;
   
   public GameFrame()
   {
      super("PacMan");
     
      this.setLayout(new BorderLayout());

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      this.add(gamePanel, BorderLayout.CENTER);
  
      buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      buttonsPanel.add(startButton);
      buttonsPanel.add(pauseButton);
      buttonsPanel.add(quitButton);

      this.add(buttonsPanel, BorderLayout.SOUTH);


      setSize(Settings.getInstance().getSizeX(), Settings.getInstance().getSizeY() );
      
    
      
      // action listeners
      startButton.addActionListener(this);
      quitButton.addActionListener(this);
      pauseButton.addActionListener(this);
      
      this.updateGame();
   }
   
   public void actionPerformed(ActionEvent e)
   {
       System.out.println("action catched");
       
      Object s = e.getSource();
      if (s == startButton)
      {
         running = !running;
         if (running)
         {
            startButton.setText("Stop");
            runGameLoop();
         }
         else
         {
            startButton.setText("Start");
         }
      }
      else if (s == pauseButton)
      {
        paused = !paused;
         if (paused)
         {
            pauseButton.setText("Unpause");
         }
         else
         {
            pauseButton.setText("Pause");
         }
      }
      else if (s == quitButton)
      {
         System.exit(0);
      }
   }
   
   //Starts a new thread and runs the game loop in it.
   public void runGameLoop()
   {
      Thread loop = new Thread()
      {
         public void run()
         {
            gameLoop();
         }
      };
      loop.start();
   }
   
   //Only run this in another Thread!
   private void gameLoop()
   {
      //This value would probably be stored elsewhere.
      final double GAME_HERTZ = 30.0;
      //Calculate how many ns each frame should take for our target game hertz.
      final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
      //At the very most we will update the game this many times before a new render.
      //If you're worried about visual hitches more than perfect timing, set this to 1.
      final int MAX_UPDATES_BEFORE_RENDER = 5;
      //We will need the last update time.
      double lastUpdateTime = System.nanoTime();
      //Store the last time we rendered.
      double lastRenderTime = System.nanoTime();
      
      //If we are able to get as high as this FPS, don't render again.
      final double TARGET_FPS = 60;
      final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
      
      //Simple way of finding FPS.
      int lastSecondTime = (int) (lastUpdateTime / 1000000000);
      
      while (running)
      {
         double now = System.nanoTime();
         int updateCount = 0;
         
         if (!paused)
         {
             //Do as many game updates as we need to, potentially playing catchup.
            while( now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER )
            {
               updateGame();
               lastUpdateTime += TIME_BETWEEN_UPDATES;
               updateCount++;
            }
   
            //If for some reason an update takes forever, we don't want to do an insane number of catchups.
            //If you were doing some sort of game that needed to keep EXACT time, you would get rid of this.
            if ( now - lastUpdateTime > TIME_BETWEEN_UPDATES)
            {
               lastUpdateTime = now - TIME_BETWEEN_UPDATES;
            }
         
            //Render. To do so, we need to calculate interpolation for a smooth render.
            drawGame();
            lastRenderTime = now;
         
            //Update the frames we got.
            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime)
            {
               //System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                
               fps = frameCount;
               frameCount = 0;
               lastSecondTime = thisSecond;
            }
         
            //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
            while ( now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES)
            {
               Thread.yield();
            
               //This stops the app from consuming all your CPU. It makes this slightly less accurate, but is worth it.
               //You can remove this line and it will still work (better), your CPU just climbs on certain OSes.
               //FYI on some OS's this can cause pretty bad stuttering. Scroll down and have a look at different peoples' solutions to this.
               try {Thread.sleep(1);} catch(Exception e) {} 
            
               now = System.nanoTime();
            }
         }
      }
   }
   
   private void updateGame()
   {
      gamePanel.update();
   }
   
   private void drawGame()
   {
      gamePanel.repaint();
   }
}