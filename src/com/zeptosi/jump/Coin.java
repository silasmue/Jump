/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author news
 */
public class Coin extends GameObject{
    private Circle coin;
    private final double radius = 32;
    
    public Coin(double pXcenter, double pYcenter, ID pID) {
        super(pID); //width and height of a coin isn't settible
        coin = new Circle();
        coin.setCenterX(pXcenter);
        coin.setCenterY(pYcenter);
        coin.setRadius(radius); //half of widht
        coin.setFill(Color.GOLD);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.GOLD);
        gc.fillOval(getX() - radius , getY() - radius, radius*2, radius*2);
        //gc.drawImage(Game.getTexture().getCoin(), getX() - radius, getY() - radius, 64, 64);
    }

    @Override
    public double getX() {
        return coin.getCenterX();
    }

    @Override
    public void setX(double x) {
        this.coin.setCenterX(x);
    }    

    @Override
    public double getY() {
        return coin.getCenterY();
    }

    @Override
    public void setY(double y) {
        this.coin.setCenterY(y);
    }
    
    @Override
    public Shape getHitbox() {
        return coin;
    }
}
