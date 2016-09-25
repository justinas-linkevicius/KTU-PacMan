/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;

/**
 *
 * @author Justinas
 */
public class Window extends JFrame {
    JTextArea textArea;
    
    public Window() throws HeadlessException {
        setTitle("Pacman");
        setSize(500,500);
        setLocationRelativeTo(null); // This centers the window on the screen.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Quit app when window closes.

        // Don't worry about what this does, but remember that it's important.
        getContentPane().setLayout(null);

        textArea = new JTextArea();
        textArea.setSize(300, 300);
        textArea.setFont(new Font("Courier New", Font.BOLD, 14));
        getContentPane().add(textArea);
        
        
        // Change textArea to a more appropriate size.
        
        char[][] board = Board.getNewBoard();
        textArea.setRows(board[0].length);
        textArea.setColumns(board.length);
        textArea.setSize(textArea.getPreferredSize());
        
        
        // The point of this text area is just to show stuff to the user;
        // we don't actually want them to edit it like a real text box,
        // so we'll make it un-editable:
        textArea.setEditable(false);

        // This prevents text selection, but has the unfortunate side effect
        // of making the text color 50% darker. Not a big deal for me, but
        // it might be for you. Just saying, y'know?
        textArea.setEnabled(false);

        // A little bit of visual polish- black on black makes the
        // textbox appear invisible, creating the illusion that it isn't there.
        // Feel free to customize as desired.
        getContentPane().setBackground(Color.BLACK);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);

        // This will get replaced eventually when our game loads:
        textArea.setText("Loading....");        
        
        Logger.getInstance().log("window loading");
    }
}
