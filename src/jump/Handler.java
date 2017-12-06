/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jump;

import java.util.LinkedList;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public class Handler {
    private LinkedList<GameObject> gameObject;
    
    public Handler() {
        gameObject = new LinkedList();
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
    
    public void tick() {
        for(int i = 0; i < gameObject.size(); i++) {
            gameObject.get(i).tick();
        }
    }
    
    public void add(GameObject pGo) {
        gameObject.add(pGo);
    }
    
    public LinkedList<GameObject> getGameObjects() {
        return gameObject;
    }
}
