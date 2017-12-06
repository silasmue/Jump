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
 * @author Silas Müller
 */
public class Player extends GameObject{
    private Rectangle player;

    public Player(int pX, int pY, ID pID) {
        super(pX, pY, pID);
    }
    
    public Player(int pX, int pY) {
        super(pX, pY, ID.Player);
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
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void updateRender() {
        player.setX(x);
        player.setY(y);
    }
    
}
