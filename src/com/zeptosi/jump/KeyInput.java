/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Silas Müller
 */
public class KeyInput {

    private static Handler handler;
    public static final Set<KeyCode> PRESSED_KEYS = new HashSet<>();

    public KeyInput(Handler pHandler) {
        handler = pHandler;
    }

    public static void processKeys() {
        if (PRESSED_KEYS.size() > 0) {
            ArrayList<GameObject> objects = handler.getGameObjects();
            for (KeyCode key : PRESSED_KEYS) {
                for (GameObject object : objects) {
                    if (object.getID() == ID.Player) {
                        if (key == KeyCode.W) {
                            object.setVelY(-3);
                        }
                        if (key == KeyCode.S) {
                            object.setVelY(3);
                        }
                        if (key == KeyCode.A) {
                            object.setVelX(-3);
                        }
                        if (key == KeyCode.D) {
                            object.setVelX(3);
                        }
                    }
                }
            }
        }
    }

    public void keyPressed(KeyCode e) {
        PRESSED_KEYS.add(e);
//        for(int i = 0; i < gameObject.size(); i++){
//            if(gameObject.get(i).getID() == ID.Player) {
//                if(e == KeyCode.W) gameObject.get(i).setVelY(-3);
//                if(e == KeyCode.S) gameObject.get(i).setVelY(3);
//                if(e == KeyCode.A) gameObject.get(i).setVelX(-3);
//                if(e == KeyCode.D) gameObject.get(i).setVelX(3);
//            }
//        }
    }

    public void keyReleased(KeyCode e) {
        PRESSED_KEYS.remove(e);
//        for(int i = 0; i < gameObject.size(); i++){
//            if(gameObject.get(i).getID() == ID.Player) {
//                if(e == KeyCode.W) gameObject.get(i).setVelY(0);
//                if(e == KeyCode.S) gameObject.get(i).setVelY(0);
//                if(e == KeyCode.A) gameObject.get(i).setVelX(0);
//                if(e == KeyCode.D) gameObject.get(i).setVelX(0);
//            }
//        }
    }
}
