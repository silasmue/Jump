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

    public Block(int pX, int pY, int pWidth, int pHeight, ID pID) {
        super(pX, pY, pWidth, pHeight,pID);
    }

    @Override
    public Shape initRender() {
        block = new Rectangle();
        block.setFill(Color.DARKBLUE);
        block.setX(x);
        block.setY(y);
        block.setWidth(width);
        block.setHeight(height);
        block.setArcHeight(0);
        block.setArcWidth(0);
        
        return block;
    }

    @Override
    public void tick() {
        //does nothing whil game ticks
    }

    @Override
    public void updateRender() {
        block.setX(x);
        block.setY(y);
    }
    
    @Override
    public Shape getShape() {
        return block;
    }
    
}
