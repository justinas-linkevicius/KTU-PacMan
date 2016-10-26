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
public abstract class AbstractLogger {
    public static final int COMMON = 1;
    public static final int SPECIAL = 2;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    public void log(int level, String msg) {
        if (this.level == level) {
            this.write(msg);
        }

        if (this.nextLogger != null) {
            nextLogger.log(level, msg);
        }
    }

    abstract protected void write(String msg);
}
