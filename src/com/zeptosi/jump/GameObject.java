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
    
    protected Shape shape;
    private int width;
    private int height;
    protected double velX, velY;
    protected ID id;
    
    public GameObject(int pWidth, int pHeight, ID pID) {
        this.width = pWidth;
        this.height = pHeight;
        this.id = pID;
    }
    
    public abstract Shape initRender();
    public abstract void tick(long diff);
    public abstract void updateRender();
    public void collide(GameObject partner, Physics.direction dir){
        
    };
    public Shape getShape(){
        return shape;
    }
    
    public abstract int getX();

    public void setX(int x){};

    public abstract int getY();

    public void setY(int y) {}

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

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
}
