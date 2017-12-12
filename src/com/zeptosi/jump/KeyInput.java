/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Silas Müller
 */
public class KeyInput {
    private Handler handler;
    private LinkedList<GameObject> gameObject = new LinkedList<GameObject>();
    
    public KeyInput(Handler pHandler) {
        handler = pHandler;
        gameObject = handler.getGameObjects();
    }
    
    public void keyPressed(KeyCode e) {
        for(GameObject i : gameObject){
            if(i.getID() == ID.Player) {
                Player p = (Player) i;
                if(e == KeyCode.W) p.setVelY(-3);
                if(e == KeyCode.S) p.setVelY(3);
                if(e == KeyCode.A) p.setVelX(-3);
                if(e == KeyCode.D) p.setVelX(3);
                if(e == KeyCode.SPACE && !p.isJumping()) {
                    p.jump();
                    i.setVelY(-20);
                }
            }
        }
    }
    
    public void keyReleased(KeyCode e) {
        for(int i = 0; i < gameObject.size(); i++){
            if(gameObject.get(i).getID() == ID.Player) {
                if(e == KeyCode.A) gameObject.get(i).setVelX(0);
                if(e == KeyCode.D) gameObject.get(i).setVelX(0);
                if(e == KeyCode.W) gameObject.get(i).setVelY(0);
                if(e == KeyCode.S) gameObject.get(i).setVelY(0);
            }
        }
    }
}
