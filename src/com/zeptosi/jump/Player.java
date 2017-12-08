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
    private Rectangle hitbox;
    private Rectangle render;
    
    private Handler handler;
    
    private final double width;
    private final double height;
    
    public Player(double pX, double pY, double pWidth, double pHeight, Handler pHandler, ID pID) {
        super(pX, pY, pID);
        width = pWidth;
        height = pHeight;

    }
    
    @Override
    public Shape init() {
        render = new Rectangle();
        render.setX(x);
        render.setY(y);
        render.setWidth(width);
        render.setHeight(height);
        render.setArcHeight(0);
        render.setArcWidth(0);
        
        hitbox = render;
        render.setFill(Color.RED);
        return render;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        updateHitbox();
        
        
        LinkedList<GameObject> gO = new LinkedList<GameObject>();
        gO = handler.getGameObjects();
        for(GameObject g : gO) {
            System.out.println("hi" + Physics.checkCollision(hitbox, g.getHitbox()));
        }
        
    }

    @Override
    public void updateRender() {
        render = hitbox; //in this case 
    }
    
    @Override
    public Shape getHitbox() {
        return hitbox;
    }
    
    private void updateHitbox() {
        hitbox.setX(x);
        hitbox.setY(y);
    }
          
}
