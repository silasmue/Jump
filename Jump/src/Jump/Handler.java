/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jump;

import java.util.LinkedList;


/**
 *
 * @author Silas Mueller
 */

/*This class contains a linked list of all gameobjects and functions to manage them*/
public class Handler {
    /**
     * LinkedList of the type GameObject.
     * The list holds every object in the game.
     */
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public Handler() {
        
    }
    /**
     * Let every Object in the game tick.
     *  When an object ticks it executes it's internal tick algorithm
     */
    public void tick() {
        for(int i = 0; i < object.size(); i++) {
            object.get(i).tick();
        }
    }
    /**
     * The render-method executes every gamobjects render-method.
     */
    public void render(/*something like graphics g in javaFX*/) {
        for(int i = 0; i < object.size(); i++) {
            object.get(i).render(/*something like graphics g in javaFX*/);
        }
    }
    
    public void add(GameObject tmpObject) {
        object.add(tmpObject);
    }
        
    
}
