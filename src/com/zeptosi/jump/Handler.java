/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.event.EventType;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public class Handler {
    private LinkedList<GameObject> gameObject;
    private HUD hud;
    
    public Handler() {
        gameObject = new LinkedList();
    }
    
    public LinkedList<Shape> initRender() {
        LinkedList<Shape> shape = new LinkedList<Shape>();
        for(GameObject g : gameObject) {
            shape.add(g.initRender());
        }
        hud = new HUD(this); //now to be able to get player
        
        for(Shape s : hud.initRender()) {
            shape.add(s);
        }
        
        return shape;
    }
        
    public void updateRender() {
        for(int i = 0; i < gameObject.size(); i++) {
            hud.updateRender();
            //gameObject.get(i).updateRender();
        }
    }
    
    public void tick() {
        for(GameObject gO : gameObject) {
            gO.tick();
        }
    }
    
    public void add(GameObject pGo) {
        gameObject.add(pGo);
    }
    
    public LinkedList<GameObject> getGameObjects() {
        return gameObject;
    }
}
