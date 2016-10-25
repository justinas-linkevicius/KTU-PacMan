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
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        BufferedWriter pw = null;
        try {
            pw = new BufferedWriter(new FileWriter("LOG", true));
            pw.write(msg + "\n");
            pw.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}