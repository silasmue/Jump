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
    protected Shape shape;
    protected double velX, velY;
    protected double width, height;
    protected ID id;
    
    public GameObject(double pWidth, double pHeight, ID pID) {
        this.width = pWidth;
        this.height = pHeight;
        this.id = pID;
    }
    
    public abstract Shape initRender();
    public abstract void tick();
    public abstract void updateRender();

    public abstract double getX();
    public abstract void setX(double x);
    public abstract double getY();
    public abstract void setY(double y);
    
    public Shape getHitbox() {
        return shape;
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
