/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;

/**
 *
 * @author news
 */
public class Camera {
    /**
     * x, y are the coordinates where the player should be on the screen
     */
    private double x, y;
    private Handler handler;
    
    public Camera(double pX, double pY, Handler pHandler) {
        x = pX;
        y = pY;
        handler = pHandler;
    }
    
    public void tick() {
        //actually player has index 0
        //Player p = (Player) handler.getGameObjects().get(0); //Risky thing dont wanna loop double
        Player p = null;
        for(GameObject o : handler.getGameObjects()) {
            if(o.getID() == ID.Player) {
                 p = (Player) o; //works only for one player //working on fix but fix isnt imp. yet only for multiplayer
            }
        }
        
        for(GameObject o : handler.getGameObjects()) {
            double movementX = p.getX() - p.getLastX();
            double movementY = p.getY() - p.getLastY();
            o.setX(o.getX() - movementX + x);
            //o.setY(o.getY() - movementY + y); nor neccessary yet and buggy when jumping
        }
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double pX) {
        x = pX;
    }
    
    public void setY(double pY) {
        x = pY;
    }
}
