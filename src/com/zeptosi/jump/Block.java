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
    
    public Block(double pX, double pY, double pWidth, double pHeight, ID pID) {
        super(pWidth, pHeight, pID);
        block = new Rectangle();
        block.setX(pX);
        block.setY(pY);
        block.setWidth(pWidth);
        block.setHeight(pHeight);
    }

    @Override
    public Shape initRender() {
        block.setArcHeight(0);
        block.setArcWidth(0);
        
        shape = block;
        return block;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void updateRender() {
        shape = block;
    }


    @Override
    public double getX() {
       return block.getBoundsInParent().getMinX();
    }

    @Override
    public void setX(double x) {
        block.setX(x);
    }

    @Override
    public double getY() {
        return block.getBoundsInParent().getMinY();
    }

    @Override
    public void setY(double y) {
        block.setY(y);
    }
    
}
