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

    public Player(int pX, int pY, ID pID, Handler pHandler) {
        super(pX, pY, pID);
        handler = pHandler;
    }

    @Override
    public Shape initRender() {
        player = new Rectangle();
        player.setFill(Color.BURLYWOOD);
        player.setX(x);
        player.setY(y);
        player.setWidth(64);
        player.setHeight(128);
        player.setArcHeight(0);
        player.setArcWidth(0);
                
        return player;
        
    }

    @Override
<<<<<<< HEAD
    public void tick(int time) {
=======
    public void tick() {
        if(Collision()) {
            velX += velX * -1;
            velY += velY * -1;
        }
>>>>>>> master
        x += velX;
        y += velY;
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
    
    private boolean Collision() {
        LinkedList<GameObject> gameObject = new LinkedList<GameObject>();
        gameObject = handler.getGameObjects();
        Shape tmpShape;
        Shape intersection;
        
        for(int i = 0; i < gameObject.size(); i++) {
            if(gameObject.get(i).getID() == ID.Block) {
                tmpShape = gameObject.get(i).getShape();
                intersection = Shape.intersect(tmpShape, player);
                
                if(intersection.getBoundsInLocal().getWidth() != -1) {
                return true;
                }
                
            }
            else return false;
        }
        return false;
    }
        
}
