/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author news
 */
public class Haunter extends Enemy{
    private Handler handler;
    private boolean falling, jumping;
    private final double gravity = 0.5;
    private int dirChangeCd;


    public Haunter(double pX, double pY,Handler pHandler, ID pID) {
        super(pX, pY, pID);
        type = Enemy.Type.HAUNTER;
        handler = pHandler;
        enemy.setWidth(64); //fixed size
        enemy.setHeight(64);
        
        falling = true;
        jumping = true;
        
        killScore = 45;
        dirChangeCd = 10;
    }

    @Override
    public void tick() {
        if(falling || jumping) {
            velY += gravity;
        }
        if((!falling && !jumping) && velX == 0) {
            velX = 4;
        }
        
        
        LinkedList<GameObject> gO = new LinkedList<GameObject>();
        gO = handler.getGameObjects();
        
        setX(getX() + velX);
        dirChangeCd ++;
        for(int i = 0; i < gO.size(); i++) {
            if(gO.get(i).getID() == ID.BLOCK) {
                if(Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velX > 0) {
                        setX(getX() - Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getWidth());
                        handler.addToRemove(this);
                    }
                    if(velX < 0) {
                        setX(getX() + Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getWidth());
                        handler.addToRemove(this);
                    }
                    
                }
            }
            if(gO.get(i).getID() == ID.PLAYER) {
                    Player p = (Player)gO.get(i);
                    
                    if(p.getX() < enemy.getX()) {
                        if(dirChangeCd == 30) {
                            velX = -4;
                            dirChangeCd = 0;
                        }
                        else velX = velX;
                        
                    }
                    if(p.getX() > enemy.getX() ) {
                        if(dirChangeCd == 30) {
                            velX = 4;
                            dirChangeCd = 0;
                        }
                        else velX = velX;
                    }
                    
            }
        }
        setY(getY() + velY);
        for(int i = 0; i < gO.size(); i++) { 
            if(gO.get(i).getID() == ID.BLOCK) {
                if(Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velY > 0) { // collision on bot side of the gO
                        setY(getY() - Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getHeight());
                        falling = false;
                        jumping = false;
                    }
                    if(velY < 0) {
                        setY(getY() + Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getHeight());
                        velY = 0;
                    }
                }
            }
        }
    }
    
    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.BROWN);
        gc.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
    public double getWidth() {
        return enemy.getWidth();
    }
    
    public double getHeight() {
        return enemy.getHeight();
    }

    @Override
    public int getKillScore() {
        return killScore;
    }
    
}
