/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public class GameLoop extends AnimationTimer{
    /**
     * instance of Handler to get access to all objects in the game (GameObject)
     */
    private Handler handler;
    /**
     * 
     */
    private int playerIndex;
    /**
     * 
     * @param pHandler
     * @param pPlayerIndex 
     */
    public GameLoop(Handler pHandler, int pPlayerIndex) {
        this.handler = pHandler;
        this.playerIndex = pPlayerIndex;
    }
    
    /**
     * JavaFX Animationtimer handle-method
     * updates (tick()) and renders (updateRender()) the game 60 times per second
     * @param now (JavaFX AnimationTimer start(long arg))
     */
    @Override
    public void handle(long now) {
        handler.tick();
        handler.updateRender();   
    }    
}
