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
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
    private Camera cam;
    private GameLoop gl;
    private boolean running = false;
    /**
     * Group root is global to add nodes in special situations for example the pause menu
     * because we got no constuctor here
     */
    private Group root = new Group();
    /**
     * JavaFX start-Method
     * @param stage primary stage (see JavaFX start)
     */    
    @Override
    public void start(Stage stage) {
        
        initGame();
        
        stage.setTitle("Jump");
        stage.setResizable(false);
        
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

        gl = new GameLoop(handler, cam);
        gl.start();
        running = true;
    }
    
    public void esc() {
        if(running){
            gl.stop();
            running = false;
            pauseMenu();
        }
        else {
            gl.start();
            running = true;
        }
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
        keyListener = new KeyInput(handler, this);
        
        
        new Level(100, 15, handler);
        handler.add(new Player(200, 300, 64, 128, handler, ID.PLAYER));
        cam = new Camera(200, 300, handler); //add Level.getStart() to get levels start point for the camera
    }
    
    private void pauseMenu() {
        VBox pauseMenu = new VBox();
        pauseMenu.setSpacing(10);
        
        Button resume = new Button("Resume");
        resume.setMinWidth(WIDTH/10);
        resume.setMinHeight(HEIGHT/10);
        resume.setStyle("-fx-background-color:\n" +
                            "linear-gradient(#f0ff35, #a9ff00),\n" +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);"
                        );
        Button exit = new Button("End game");
        exit.setMinWidth(WIDTH/10);
        exit.setMinHeight(HEIGHT/10);
        exit.setStyle("-fx-background-color:\n" +
                            "linear-gradient(#f0ff35, #a9ff00),\n" +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);"
                        );
        
        
        
        pauseMenu.getChildren().add(resume);
        pauseMenu.getChildren().add(exit);
        
        pauseMenu.setLayoutX(WIDTH/2 - resume.getMinWidth());
        root.getChildren().add(pauseMenu);
        
        resume.setOnAction(e -> {
            pauseMenu.getChildren().removeAll(); //unneccessary but just for fun to get everything clean
            root.getChildren().remove(pauseMenu);
            gl.start();
            running = true;
        });
        exit.setOnAction(e -> System.exit(0));
    }
    
    

}
