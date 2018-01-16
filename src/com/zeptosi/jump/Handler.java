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
    private HUD hud;
    private Player player;
    
    public Handler() {
        gameObject = new LinkedList();
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
        int size = gameObject.size();
        for(int i = 0; i < size; i++) {
            gameObject.get(i).tick();
            if(size != gameObject.size()) {
                size = gameObject.size();
                i--; //evt bugs desegen
            }
        }
    }
    
    public void add(GameObject pGo) {
        gameObject.add(pGo);
        if(pGo.getID() == ID.PLAYER) {
            player = (Player)gameObject.getLast();
        }
    }
    
    public LinkedList<GameObject> getGameObjects() {
        return gameObject;
    }
    
    public void remove(GameObject pGo) {
        gameObject.remove(pGo);
    }
        
    public void removeAll(LinkedList<GameObject> gO) {
        gameObject.removeAll(gO);
    }
    
    public LinkedList<GameObject> getClosest(double pX, double pY) {
        LinkedList<GameObject> closest = new LinkedList();
        for(GameObject o : gameObject) {
            double x = o.getX();
            double y = o.getY();
            if(Math.abs(x - pX) <= 5 * 64 && Math.abs(y - pY) <= 5 * 64) {
                closest.add(o);
            }
        }
        return closest;
    }
    
    public Player getPlayer() {
        return player;
    }
}
