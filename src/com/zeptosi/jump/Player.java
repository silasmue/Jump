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
    
    private int health;
    private int coins;
    
    public Player(double pX, double pY, double pWidth, double pHeight, Handler pHandler, ID pID) {
        super(pID);
        handler = pHandler;
        player = new Rectangle(pX, pY, pWidth, pHeight);
        player.setFill(Color.RED);
        player.setArcHeight(0);
        player.setArcWidth(0);
        falling = true;
        jumping = true;
        
        health = 100;
    }

    @Override
    public void tick() {
        if(falling || jumping) {
            velY += 0.5;
        }
        
        LinkedList<GameObject> gO = new LinkedList<GameObject>();
        gO = handler.getGameObjects();
        
        setX(getX() + velX);
        for(int i = 0; i < gO.size(); i++) { //can not use enhanced for-loop because we are deleting and element of the LinkedList
            if(gO.get(i).getID() == ID.BLOCK) {
                if(Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velX > 0) {
                        setX(getX() - Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth());
                    }
                    if(velX < 0) {
                        setX(getX() + Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth());
                    }
                }
            }
            if(gO.get(i).getID() == ID.COIN) {
                if(Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1) {
                    coins++;
                    handler.remove(gO.get(i));
                    i--; //to not miss somthing //Herr Krieg fragen
                }
            }
        }
        setY(getY() + velY);
        for(int i = 0; i < gO.size(); i++) { //can not use enhanced for-loop because we are deleting and element of the LinkedList
            if(gO.get(i).getID() == ID.BLOCK) {
                if(Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velY > 0) { // collision on bot side of the player
                        setY(getY() - Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getHeight());
                        falling = false;
                        jumping = false;
                    }
                    if(velY < 0) {
                        setY(getY() + Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getHeight());
                        velY = 0;
                    }
                }
            }
            if(gO.get(i).getID() == ID.COIN) {
                if(Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1) {
                    coins++;
                    handler.remove(gO.get(i));
                    i--;  //to not miss somthing //Herr Krieg fragen
                }
            }
        }
        //System.out.println(coins);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(getX(), getY(), getWidth(), getHeight());
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
    
    @Override
    public Shape getHitbox() {
        return player;
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
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public double getWidth() {
        return player.getWidth();
    }
    
    public double getHeight() {
        return player.getHeight();
    }
    
    public int getCoins() {
        return coins;
    }
    
}