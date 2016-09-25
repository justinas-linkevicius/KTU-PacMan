/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/**
 *
 * @author Justinas
 */
public class Board
{
    private char[][] board;
    
    public Board()
    {
        // Initialize the 'board' variable.
        board = getNewBoard();
    }

    // This code is used in the Board constructor, and also in the Window
    // class to determine dimensions. getNewBoard() returns a character array
    // representing a clean board from board.txt
    public static char[][] getNewBoard()
    {
        
        // Load board.txt into an array and return it. InputStreams are
        // annoying; see the note at convertStreamToString()
        InputStream boardIS = Board.class.getResourceAsStream("board.txt");
        String boardStr = "";
        try {
            boardStr = convertStreamToString(boardIS);
        } catch (IOException ex) {
            System.out.println("convertStreamToString() failed!");
        }

        String[] lines = boardStr.split("\r\n|\r|\n");

        int maxLineLength = 0;
        for(int i=0;i<lines.length;i++) {
            if(maxLineLength < lines[i].length())
                maxLineLength = lines[i].length();
        }

        char[][] result = new char[maxLineLength][lines.length];
        for(int i=0;i<result.length;i++) {
            for(int k=0;k<result[i].length;k++) {
                result[i][k] = ' ';
            }
        }

        for(int i=0;i<lines.length;i++) {
            for(int k=0;k<lines[i].length();k++) {
                result[k][i] = lines[i].charAt(k);
            }
        }

        return result;
    }   
    
    // An InputStream presents an awkward, slightly annoying way of
    // getting data from a file. Unfortunately, Java doesn't have anything
    // better, so we use it. This method "reads" data from an InputStream
    // and returns the contents of the file as a String.
    private static String convertStreamToString(InputStream is)
            throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
}
