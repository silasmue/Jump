/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public abstract class GameObject {
    protected int x, y;
    protected int velX, velY;
    protected ID id;
    
    public GameObject(int pX, int pY, ID pID) {
        this.x = pX;
        this.y = pY;
        this.id = pID;
    }
    
    public abstract Shape initRender();
    public abstract void tick();
    public abstract void updateRender();
    public abstract Shape getShape();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    public ID getID() {
        return id;
    }
    
    
    
}
