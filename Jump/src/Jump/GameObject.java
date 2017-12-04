/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jump;

import java.awt.Graphics;

/**
 *
 * @author news
 */
public abstract class GameObject {
    /**
     * x-position of gameobject
     */
    protected int x;
    /**
     * y-position of gameobject
     */
    protected int y;
    /**
     * gameobject's velocity in x-direction
     * 0 is no movement
     * positive value is movement leftwards
     * negative value is movement rightwards
     */
    protected int velX;
    /**
     * gameobject's velocity in y-direction
     * 0 is no movement
     * positive value is movement downwards
     * negative value is movement upwards
     */
    protected int velY;
    /**
     * ID of the game object used as type of the game object see enumerations ID.java
     */
    protected ID id;
    
    public GameObject(int pX, int pY, ID pId) {
        this.x = pX;
        this.y = pY;
        this.id = pId;
    }
    
    public abstract void tick();
    public abstract void render(/*something like graphics g in javaFX*/);
    
    /**
     * Getters and Setters for x, y, velX and velY
     */

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
       
    
}
