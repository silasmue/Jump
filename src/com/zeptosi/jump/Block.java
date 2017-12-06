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

    public Block(int pX, int pY, ID pID) {
        super(pX, pY, pID);
    }
    
     public Block(int pX, int pY) {
        super(pX, pY, ID.Block);
    }

    @Override
    public Shape initRender() {
        block = new Rectangle();
        block.setFill(Color.DARKBLUE);
        block.setX(x);
        block.setY(y);
        block.setWidth(64);
        block.setHeight(64);
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
