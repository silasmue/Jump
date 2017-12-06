/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public class Handler {
    private ArrayList<GameObject> gameObject;
    
    public Handler() {
        gameObject = new ArrayList<>();
    }
    
    public LinkedList<Shape> initRender() {
        LinkedList<Shape> shape = new LinkedList<Shape>();
        for(int i = 0; i < gameObject.size(); i++) {
            shape.add(gameObject.get(i).initRender());
        }
        return shape;
    }
        
    public void updateRender() {
        for(int i = 0; i < gameObject.size(); i++) {
            gameObject.get(i).updateRender();
        }
    }
    
    public void tick(long now) {
        for(int i = 0; i < gameObject.size(); i++) {
            gameObject.get(i).tick(0);
        }
    }
    
    public void add(GameObject pGo) {
        gameObject.add(pGo);
    }
    
    public ArrayList<GameObject> getGameObjects() {
        return gameObject;
    }
}
