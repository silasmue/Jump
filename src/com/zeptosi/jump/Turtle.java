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
public class Turtle extends Enemy { 
    private Handler handler;
    private boolean falling, jumping;
    private final double gravity = 0.5;


    public Turtle(double pX, double pY,Handler pHandler, ID pID) {
        super(pX, pY, pID);
        type = Type.TURTLE;
        handler = pHandler;
        enemy.setWidth(64); //fixed size
        enemy.setHeight(64);
        
        falling = true;
        jumping = true;
        killScore = 25;
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
        gO = handler.getClosest(getX(), getY());
        
        setX(getX() + velX);
        for(int i = 0; i < gO.size(); i++) {
            if(gO.get(i).getID() == ID.BLOCK) {
                
                if(Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velX > 0) {
                        setX(getX() - Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getWidth());
                    }
                    if(velX < 0) {
                        setX(getX() + Shape.intersect(enemy, gO.get(i).getHitbox()).getBoundsInParent().getWidth());
                    }
                    velX = velX * -1;
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
        gc.setFill(Color.GREEN);
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
