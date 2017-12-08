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
    
    private Rectangle block;
    
     public Block(int pX, int pY, int pWidth, int pHeight) {
        super(pWidth, pHeight,ID.BLOCK);
        block = new Rectangle();
        block.setX(pX);
        block.setY(pY);
    }

    @Override
    public Shape initRender() {
        block.setFill(Color.DARKBLUE);
        block.setWidth(getWidth());
        block.setHeight(getHeight());
        block.setArcHeight(0);
        block.setArcWidth(0);
        
        return block;
    }

    @Override
    public void updateRender() {
    }
    
    @Override
    public Shape getShape() {
        return block;
    }

    @Override
    public void tick(long diff) {
        
    }

    @Override
    public int getX() {
        return (int) block.getX();
    }

    @Override
    public int getY() {
        return (int) block.getY();
    }
    
}
