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
    
    private int lastX;
    private int lastY;
    
    private boolean jumping = false;
    private boolean falling = true;
    private int gravity = 1;
    private int max_velocity = 10;
    
    public enum Axis {
        X,Y;
    }
    
    public Player(int pX, int pY,int pWidth, int pHeight, ID pID, Handler pHandler) {
        super(pX, pY, pWidth, pHeight, pID);
        lastX = x;
        lastY = y;
        handler = pHandler;
    }

    @Override
    public Shape initRender() {
        player = new Rectangle();
        player.setFill(Color.BURLYWOOD);
        player.setX(x);
        player.setY(y);
        player.setWidth(width);
        player.setHeight(height);
        player.setArcHeight(0);
        player.setArcWidth(0);
                
        return player;
        
    }

    @Override
    public void tick() {
        LinkedList<GameObject> gameObject = new LinkedList<GameObject>();
        gameObject = handler.getGameObjects();
        
        lastX = x;
        lastY = y;
        
        x += velX;
        for(GameObject s : gameObject) {
            if(s.getID() == ID.Block) {
                if(Shape.intersect(player, s.getShape()).getBoundsInParent().getWidth() != -1) {
                    collision(Shape.intersect(player, s.getShape()), Axis.X);     
            }
            else continue;
            }         
        }
        
        y += velY;
        for(GameObject s : gameObject) {
            if(s.getID() == ID.Block) {
                if(Shape.intersect(player, s.getShape()).getBoundsInParent().getWidth() != -1) {
                    //collision(Shape.intersect(player, s.getShape()), Axis.Y);     
            }
            else continue;
            }         
        }
        
        
        //if (falling || jumping) {
        //    velY += gravity;
        //}
                
        //if (velX >= max_velocity) velX = max_velocity;
        //if (velY >= max_velocity) velY = max_velocity;
    }
    
    @Override
    public void updateRender() {
        player.setX(x);
        player.setY(y);
    }
    
    @Override
    public Shape getShape() {
        return player;
    }
    
    public void setJumping(boolean pJumping) {
        jumping = true;
    }
    
    public boolean getJumping() {
        return jumping;
    }
    
    public int getMax_velocity() {
        return max_velocity;
    }
    
    private void collision(Shape pIntersection, Axis a) {
        if(a == Axis.X){
            double width = pIntersection.getBoundsInParent().getWidth();
            if(velX > 0) {
                x -= width ;
                velX = 0;
            }
            if(velX < 0) {
                x += width ;
                velX = 0;
            }
        }
        if(a == Axis.Y){
            double height = pIntersection.getBoundsInParent().getHeight();
            if(velY > 0) {
                y -= height ;
                velY = 0;
            }
            if(velY < 0) {
                y += height ; 
                velY = 0;
            }
        }
  
    }
           
}
