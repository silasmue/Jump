/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public class Player extends GameObject {

    private Rectangle player;
    private Handler handler;

    public Player(int pX, int pY, int pWidth, int pHeight, ID pID, Handler pHandler) {
        super(pWidth, pHeight, pID);
        handler = pHandler;
        player = new Rectangle();
        player.setX(pX);
        player.setY(pY);
    }

    @Override
    public Shape initRender() {
        player.setFill(Color.BURLYWOOD);
        player.setWidth(getWidth());
        player.setHeight(getHeight());
        player.setArcHeight(0);
        player.setArcWidth(0);
        shape = player;
        return player;

    }

    @Override
    public void tick(long time) {

    }

    @Override
    public void updateRender() {
    }

    @Override
    public Shape getShape() {
        return player;
    }

    @Override
    public void collide(GameObject partner, Physics.direction dir) {
        this.setVelY(0);
    }

    @Override
    public int getX() {
        return (int) player.getX();
    }

    @Override
    public int getY() {
        return (int) player.getY();
    }

    @Override
    public void setX(int x) {
        player.setX(x);
    }

    @Override
    public void setY(int y) {
        player.setY(y);
    }

}
