/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Justinas
 */
public class GameState implements IGameState
{
    private List<Enemy> enemies = new LinkedList<Enemy>();
    private int enemyState = 1;    
    
    public int getEnemyState()
    {
        return enemyState;
    }
    
    public void setEnemyState( int state )
    {
        this.enemyState = state;
        this.notifyEnemies();
    }
    
    public void addEnemy( Enemy e )
    {
        System.out.println("addEnemy()");
        this.enemies.add(e);
    }
    
    public void notifyEnemies()
    {
        System.out.println("updating");
        for(Enemy o: enemies)
        {
            o.updateState();
        }
    }
}
