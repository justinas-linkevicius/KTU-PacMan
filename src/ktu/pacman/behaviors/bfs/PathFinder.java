/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ktu.pacman.behaviors.bfs;

import java.awt.Point;
import ktu.pacman.DirectionEnum;

/*------------------------------------------------------------------------
 * CS60 Spring, 2000
 * Name         :   SooYoung Jung
 * Filename     :   Maze.java
 * Assignment   :   5
 * Date         :   February 24, 2000
 * Description  :   This program is that a laboratory mouse is seeking the 
 *                  shortest path from its starting point in a maze to an 
 *                  appropriate destination, i.e., a can of spam). To reach the 
 *                  spam by the shortest possible path, uses implementing 
 *                  breadth-first search.
 */

/*
 * The Maze class is in essence a two-dimensional array of
 *   MazeCells. In addition, each Maze has a name, a height
 *   and width, and the x- and y- coordinates of the
 *   starting point and finishing point (the spam) are maintained.
 */

public class PathFinder
{
    private final char wallSymbol = '1';
    private char endPointSymbol;
    
    private PathCell[][] grid;
    private int         width;
    private int        height;
    private int        startx;
    private int        starty;
    private int         endx;
    private int         endy;
  
    /* 
     * These static arrays of Strings represent the mazes
     *  available. The constructor for the Maze class
     *  needs one of the names of these mazes as input,
     *  it then initializes the array of MazeCells appropriately.
     *
     * The first string is the maze's name.
     * The second string is the maze's height.
     * The third string is the maze's width.
     * The remaining strings are the contents of the maze:
     *   a '|' or '-' character represents a wall
     *   a capital S represents the starting point
     *   a capital X represents the finishing point (the spam)
     *
     * These are static data members, meaning that they "belong to"
     *   the maze class, not every constructed maze object.
     *   After all, any particular object only needs to know
     *   about the single maze it's representing.
     */

    /* 
     * This constructor takes in the name of one of the 
     *  above statically defined String arrays and creates 
     *  the maze represented in the specified array.
     */

    public PathFinder(char[][] info, Point startPoint, Point endPoint) 
    {
        height  = info.length;
        width   = info[0].length;
        grid    = new PathCell[height][width];
    
        startx = startPoint.y;
        starty = startPoint.x;
        
        endx = endPoint.y;
        endy = endPoint.x;
        
        endPointSymbol = info[endy][endx];
        
        /*
        System.out.println("in PathFinder();");
        System.out.println("start pos: " + info[startx][starty]);
        System.out.println("start pos: " + info[endx][endy]);
        */
                
        // fill the grid
        for (int i=0 ; i<height ; ++i) 
            for (int j=0 ; j<width ; ++j) 
                grid[i][j] = new PathCell(j,i,info[i][j]);
    }


    /*
     * The printMark method changes contents of the PathCell to '*'
     *   here invoked Queue is shortest path.
     */
    public void printMark(PathCell pathCell) 
    {
        while ( pathCell.getParent() != null ) 
        {                   // changes contents until it meets null pointer.
            pathCell = pathCell.getParent();
               pathCell.star();
        }
    }   
    
 
    /*
     * The toString method allows a user to print
     *   a Maze Object with the System.out.println
     *   command
     */

    public String toString()
    {
        StringBuffer theFullAnswer = new StringBuffer();
        
        for (int i=0 ; i<height; i++) 
        {
            for (int j=0 ; j<width; j++) 
            {
                theFullAnswer.append(String.valueOf(grid[i][j].getContents()));
            }
            theFullAnswer.append("\n");
        }

        theFullAnswer.append("\n");
        return theFullAnswer.toString();
    }
    
    public String[][] getGrid()
    {
        String ans[][] = new String[height][width];
        for (int i=0 ; i<height ; ++i) 
        {
            for (int j=0 ; j<width ; ++j) 
            {
                ans[i][j] = String.valueOf(grid[i][j].getContents());
            }
        }
        
        return ans;
    }
    
    public DirectionEnum getFirstMove()
    {
        char charTop    = grid[starty-1][startx].getContents();
        char charBottom = grid[starty+1][startx].getContents();
        char charLeft   = grid[starty][startx-1].getContents();
        char charRight  = grid[starty][startx+1].getContents();
        
        String toFind = "#*";
        
        // find path or pacman
        // top
        if( toFind.indexOf(charTop) != -1 )
        {
            return DirectionEnum.UP;
        }
        
        // bottom
        if( toFind.indexOf(charBottom) != -1 )
        {
            return DirectionEnum.BOTTOM;
        }
        
        // left
        if( toFind.indexOf(charLeft) != -1 )
        {
            return DirectionEnum.LEFT;
        }
        
        // right
        if( toFind.indexOf(charRight) != -1 )
        {
            return DirectionEnum.RIGHT;
        }
        
        return DirectionEnum.NONE;
    }
  
    /* 
     * BFS routine 
     * Using Queue, this solve() method is doing BFS.
     * enqueue all children and deque them until it gets final point.
     */
  
    public boolean solve() 
    {
        PathCell N, S, E, W;
        
        // Store North, South, East, and West of PathCell.
        Queue Q = new Queue();
        
        // Create new Queue to do BFS                    
        PathCell startCell = new PathCell(startx, starty, 'S');
                            
        // Create PathCell and mark it as starting cell.
        startCell.Mark();
        
        // Set it as visited.                    
        Queue.enqueue(startCell, Q);
    
        PathCell CMC = null;
        while(!Queue.is_empty(Q))
        {
            CMC = (PathCell)Queue.dequeue(Q);

            if( CMC.getContents() == endPointSymbol )
            {               
                // Checks content of dequeued Cell.
                // If it is 'X', found finish position.
                printMark(CMC);
                
                // Print '*' mark at shortest path.
                return true;
            }

            // North child
            // store North child which can be the one of 
            // shortest path
            
            if ( !((CMC.yValue() ) <= 0) )
            {               // Out of range.
        
                N = (grid[(CMC.yValue())-1][CMC.xValue()]);
                
                // Gets north PathCell
                if ( N.getContents() != '#' && N.getContents() != wallSymbol && !(N.isMarked()) )
                {           // If content is not wall and have not visited,
                            // For North PathCell
                    N.Mark();
                            // Set it as visited cell.
                            
                    CMC.changeParent(N);
                            // Keep parent's infomation so later it can trace
                            // shortest paht from finish point to start point.
                            
                    Queue.enqueue( N, Q );
                }
            }

            // South child
            // store South child which can be the one of 
            // shortest path
            if ( !((CMC.yValue()) + 1 >= height) )
            {               // Out of range.
            
                S = (grid[(CMC.yValue())+1][CMC.xValue()]);             
                            // Gets South PathCell
                            
                if ( S.getContents() != wallSymbol && S.getContents() != '#' && !(S.isMarked()) )
                {           // If content is not wall and have not visited.
                            // For North PathCell
                    S.Mark();
                            // Set it as visited cell.
                            
                    CMC.changeParent(S);
                            // Keep parent's infomation so later it can trace
                            // shortest paht from finish point to start point.
                            
                    Queue.enqueue( S, Q );
                }
            }

            // East child
            // store East child which can be the one of 
            // shortest East
            if ( !((CMC.xValue()) - 1 <= 0) )
            {                   // Out of range.   
                E = (grid[CMC.yValue()][(CMC.xValue())-1]);
                
                // Gets East PathCell                          
                if ( E.getContents() != wallSymbol && E.getContents() != '#' && !(E.isMarked()) )
                {           
                    // If content is not wall and have not visited,
                    // For North PathCell
                    E.Mark();
                    
                    // Set it as visited cell.
                    CMC.changeParent(E);
                    
                    // Keep parent's infomation so later it can trace
                    // shortest paht from finish point to start point.
                    Queue.enqueue( E, Q );
                }
            }

            // West child
            // store West child which can be the one of 
            // shortest path
            if ( !((CMC.xValue()) + 1 >= width) )
            {              // Out of range.

                
                W = (grid[CMC.yValue()][(CMC.xValue())+1]);
                
                // Gets West PathCell
                if ( W.getContents() != wallSymbol && W.getContents() != '#' && !(W.isMarked()) )
                {           
                    // If content is not wall and have not visited,
                    // For North PathCell
                    W.Mark();
                    // Set it as visited cell.
                            
                    CMC.changeParent(W);
                    // Keep parent's infomation so later it can trace
                    // shortest paht from finish point to start point.
                            
                    Queue.enqueue( W, Q );
                }
            }
        }
        
        printMark(CMC);
        
        return false;
    }
}