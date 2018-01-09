/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.event.EventType;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public class Handler {
    private LinkedList<GameObject> gameObject;
    private LinkedList<GameObject> toRemove;
    private LinkedList<GameObject> toAdd;
    private HUD hud;
    
    public Handler() {
        gameObject = new LinkedList();
        toRemove = new LinkedList();
        toAdd = new LinkedList();
        hud = new HUD(this); //now to be able to get player
    }
            
    public void render(GraphicsContext gc) {
        gc.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
        for(int i = 0; i < gameObject.size(); i++) {
            gameObject.get(i).render(gc);
            hud.render(gc);
        }
    }
    
    public void tick() {
        toRemove.clear();
        toAdd.clear();
        for(GameObject gO : gameObject) {
            gO.tick();
        }
        gameObject.removeAll(toRemove);
        gameObject.addAll(toAdd);
    }
    
    public void add(GameObject pGo) {
        gameObject.add(pGo);
    }
    
    public LinkedList<GameObject> getGameObjects() {
        return gameObject;
    }
    
    public void remove(GameObject pGo) {
        gameObject.remove(pGo);
    }
    
    public void addToRemove(GameObject pGo) {
        toRemove.add(pGo);
    }
    
    public void addToAdd(GameObject pGo) {
        toAdd.add(pGo);
    }
}
