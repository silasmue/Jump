/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller <your.name at your.org>
 */
public class Block extends GameObject{
    private Rectangle hitbox;
    private Rectangle render;
    private final double width;
    private final double height;
   
    public Block(double pX, double pY, double pWidth, double pHeight, ID pID) {
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
        render.setFill(Color.BLACK);
        return render;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void updateRender() {
        render = hitbox;
    }
    
    public Shape getHitbox() {
        return hitbox;
    }
    
}
