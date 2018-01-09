/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * class Enemy
 * enemy is an abstract class
 * enemys have a rectangluar hitbox
 * @author Silas Müller
 */
public abstract class Enemy extends GameObject{
    
    public enum Type {
        TURTLE,
        HAUNTER,
        PATROL,
        CARNIVORE;
    }
    
    /**
     * 
     * @param pID 
     */
    
    protected Rectangle enemy;
    protected double damage; //damage that the enemy deals on collision
    protected int killScore;
    protected Type type;
    
    public Enemy(double pX, double pY, ID pID) {
        super(pID);
        enemy = new Rectangle();
        enemy.setX(pX);
        enemy.setY(pY);
    }
    
    public abstract int getKillScore();
       
    public double getX() {
        return enemy.getX();
    }
    
    public double getY() {
        return enemy.getY();
    }
    
    public void setX(double pX) {
        this.enemy.setX(pX);
    }
    
    public void setY(double pY) {
        this.enemy.setY(pY);
    }
    
    @Override
    public Shape getHitbox() {
        return enemy;
    }
    
    
}