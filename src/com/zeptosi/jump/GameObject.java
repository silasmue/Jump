/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public abstract class GameObject {
    protected double velX, velY;
    protected ID id;
    
    public GameObject(ID pID) {
        this.id = pID;
    }
    
    public abstract void tick();
    public abstract void render(GraphicsContext gc);

    public abstract double getX();
    public abstract void setX(double x);
    public abstract double getY();
    public abstract void setY(double y);
    public abstract Shape getHitbox();
    
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
