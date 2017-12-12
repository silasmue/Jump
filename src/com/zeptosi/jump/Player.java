/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public class Player extends GameObject{
    private Rectangle player;
    private Handler handler;
    
    private double lastX;
    private double lastY;
    
    private boolean jumping, falling;
    private double gravity = 0.5;
    
    public Player(double pX, double pY, double pWidth, double pHeight, Handler pHandler, ID pID) {
        super(pWidth, pHeight, pID);
        handler = pHandler;
        player = new Rectangle(pX, pY, pWidth, pHeight);
        falling = true;
        jumping = true;
    }

    @Override
    public Shape initRender() {
        player.setFill(Color.RED);
        player.setArcHeight(0);
        player.setArcWidth(0);
        
        shape = player;
        return player;
    }

    @Override
    public void tick() {
        if(falling || jumping) {
            velY += 0.5;
        }
        
        LinkedList<GameObject> gO = new LinkedList<GameObject>();
        gO = handler.getGameObjects();
        
        setX(getX() + velX);
        for(GameObject g : gO) {
            if(g.getID() != ID.Player) {
                if(Shape.intersect(player, g.getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velX > 0) {
                        setX(getX() - Shape.intersect(player, g.getHitbox()).getBoundsInParent().getWidth());
                    }
                    if(velX < 0) {
                        setX(getX() + Shape.intersect(player, g.getHitbox()).getBoundsInParent().getWidth());
                    }
                }
            }
        }
        setY(getY() + velY);
        for(GameObject g : gO) {
            if(g.getID() != ID.Player) {
                if(Shape.intersect(player, g.getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velY > 0) { // collision on bot side of the player
                        setY(getY() - Shape.intersect(player, g.getHitbox()).getBoundsInParent().getHeight());
                        falling = false;
                        jumping = false;
                    }
                    if(velY < 0) {
                        setY(getY() + Shape.intersect(player, g.getHitbox()).getBoundsInParent().getHeight());
                        velY = 0;
                    }
                }
            }
        }
    }

    @Override
    public void updateRender() {
        shape = player;
    }

    @Override
    public double getX() {
        return player.getBoundsInParent().getMinX();
    }

    @Override
    public void setX(double x) {
        player.setX(x);
    }

    @Override
    public double getY() {
        return player.getBoundsInParent().getMinY();
    }

    @Override
    public void setY(double y) {
        player.setY(y);       
    }
    
    public boolean isJumping() {
        return jumping;
    }
    
    public void jump() {
        jumping = true;
    }

    public double getLastX() {
        return lastX;
    }

    public void setLastX(double lastX) {
        this.lastX = lastX;
    }

    public double getLastY() {
        return lastY;
    }

    public void setLastY(double lastY) {
        this.lastY = lastY;
    }
    
}