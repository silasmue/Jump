/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public abstract class GameObject {
    protected double x, y;
    protected double velX, velY;
    protected ID id;
    
    public GameObject(double pX, double pY, ID pID) {
        this.x = pX;
        this.y = pY;
        this.id = pID;
    }
    
    public abstract Shape init();
    public abstract void tick();
    public abstract void updateRender();
    public abstract Shape getHitbox();

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }
    
    public ID getID() {
        return id;
    } 
    
}
