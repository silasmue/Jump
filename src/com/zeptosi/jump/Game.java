/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.beans.EventHandler;
import java.util.LinkedList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author Silas Müller
 */
public class Game extends Application{
    
    /**
     * width of the area which is displayed
     */
    private final int WIDTH = 1920;
    /**
     * height of the area which is displayed
     */
    private final int HEIGHT = WIDTH * (9/16);
    
    /**
     * instance of Handler to get access to all objects in the game (GameObject)
     */
    private Handler handler;
    /**
     * instance of KeyInput which manages the keyboard input
     */
    private KeyInput keyListener;
    
    /**
     * JavaFX start-Method
     * @param stage primary stage (see JavaFX start)
     */
    @Override
    public void start(Stage stage) {
        
        initGame();
        
        stage.setTitle("Jump");
        
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
                
        LinkedList<Shape> shape = new LinkedList<Shape>();
        shape = handler.initRender();
        for(int i = 0; i < shape.size(); i++) {
            root.getChildren().add(shape.get(i));
        }
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> keyListener.keyPressed(event.getCode()));
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> keyListener.keyReleased(event.getCode()));
        
        stage.setScene(scene);
        stage.show();
        
        AnimationTimer at = new AnimationTimer() {
            /**
             * JavaFX Animationtimer handle-method
             * updates (tick()) and renders (updateRender()) the game 60 times per second
             * @param now (JavaFX AnimationTimer start(long arg))
             */
            
            @Override
            public void handle(long now) {
               handler.tick((long) now);
               handler.updateRender();
               KeyInput.processKeys();
               System.out.println(now);
           }
        };
        at.start();
    }
    
    /**
     * main-method calls JavaFX launch(args) which starts the Application (see Application)
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * initializes and instance of Handler and and instance of KeyInput
     * initializes the game-objects
     */
    private void initGame() {
        handler = new Handler();
        keyListener = new KeyInput(handler);
        
        handler.add(new Player(200, 300, ID.Player));
    }
}
