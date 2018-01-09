/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author news
 */
public class HUD {
    private Handler handler;
    
    private int hp = 100; //for testing
    private int frames = 0;
    
    private LinkedList<Shape> hud;
    
    
    public HUD(Handler pHandler) {
        handler = pHandler;
        
    }
    
    public LinkedList<Shape> initRender() {

        return hud;
    }
    
    public void render(GraphicsContext gc) {
        /*HELATHBAR*/
        gc.setFill(Color.GREEN);
        gc.setGlobalAlpha(0.8);
        gc.fillRect(100, 100, getPlayerHealth() * 2,50);
        gc.setFill(Color.BLACK);
        gc.setGlobalAlpha(1.0);
        gc.fillRect(100, 100, 200, 2);
        gc.fillRect(100, 148, 200, 2);
        gc.fillRect(300, 100, 2, 50);
        gc.fillRect(100, 100, 2, 50);
        /*COINS*/
        gc.setFill(Color.GOLD);
        gc.fillOval(100, 160, 48, 48);
        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.setFont(new Font("Arial", 48));
        gc.fillText("" + getPlayerCoins(), 168, 202);
        /*SCORE*/
        gc.drawImage(Game.getTexture().getSkull(), 100, 30, 64, 50);
        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.setFont(new Font("Arial", 50));
        gc.fillText("" + getPlayerScore(), 168, 72);
        
        
    }
    
    private int getPlayerHealth() {
        for(GameObject g : handler.getGameObjects()){
            if(g.getID() == ID.PLAYER){
                Player p = (Player) g;
                return p.getHealth();
            }
        }
        return 0; //if no player is in game player 'has' 0hp
    }
    
    private int getPlayerCoins() {
        for(GameObject g : handler.getGameObjects()){
            if(g.getID() == ID.PLAYER){
                Player p = (Player) g;
                return p.getCoins();
            }
        }
        return 0; //if no player is in game player 'has' 0hp
    }
    
    private int getPlayerScore() {
        for(GameObject g : handler.getGameObjects()){
            if(g.getID() == ID.PLAYER){
                Player p = (Player) g;
                return p.getScore();
            }
        }
        return 0; //if no player is in game player 'has' 0hp
    }

   
    
 
}
