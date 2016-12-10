/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktu.pacman;

/**
 *
 * @author Justinas
 */
public interface IGameState
{
    public int getEnemyState();
    
    public void setEnemyState( int state );
    
    public void addEnemy( Enemy e );
    
    public void notifyEnemies();
}
