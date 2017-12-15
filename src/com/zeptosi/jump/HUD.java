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
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

/**
 *
 * @author news
 */
public class HUD {
    private Handler handler;
    
    private Rectangle health;
    private Rectangle healthBorder;
    
    private int hp = 100; //for testing
    private int frames = 0;
    
    
    public HUD(Handler pHandler) {
        handler = pHandler;
        
    }
    
    public LinkedList<Shape> initRender() {
        LinkedList<Shape> hud;
        hud = new LinkedList<Shape>();
        health = new Rectangle();
        health.setX(50);
        health.setY(50);
        health.setOpacity(0.8);
        health.setWidth(200);
        health.setHeight(50);
        health.setFill(Color.GREEN);
        
        healthBorder = new Rectangle();
        healthBorder.setFill(Color.TRANSPARENT);
        healthBorder.setX(50);
        healthBorder.setY(50);
        healthBorder.setStroke(Color.BLACK);
        healthBorder.setWidth(200);
        healthBorder.setHeight(50);
        
        hud.add(health);
        hud.add(healthBorder);
        
        return hud;
    }
    
    public void updateRender() {
        
        for(GameObject g : handler.getGameObjects()) {
            if(g.getID() == ID.PLAYER) {
                //Player p = (Player) g;
                health.setWidth(2 * hp);
            }
        }
    }
    
    private void hearts() {
        int playerHealth = 0;
        
        
    }
 
}
