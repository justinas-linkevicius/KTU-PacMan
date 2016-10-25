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
public class Enemy implements Cloneable
{
	IBehaviorAlgorithm ma;
;
	
	private Integer distance;
	
	public Enemy(Integer d){
		distance = d;
	}
	
	public void setMovingAlgorithm(IBehaviorAlgorithm p){
		ma = p;
	}
}
