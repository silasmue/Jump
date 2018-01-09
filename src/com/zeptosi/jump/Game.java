/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.beans.EventHandler;
import java.io.File;
import java.util.LinkedList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.activation.MimetypesFileTypeMap;

/**
 *
 * @author Silas Müller
 */
public class Game extends Application{
    
    /**
     * width of the area which is displayed
     */
    public static final int WIDTH = 1920;
    /**
     * height of the area which is displayed
     */
    public static final int HEIGHT = 1080;
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
    private Stage stage;
    /**
     * Group root is global to add nodes in special situations for example the pause menu
     * because we got no constuctor here
     */

    private static Texture texture;
    /**
     * JavaFX start-Method
     * @param stage primary stage (see JavaFX start)
     */    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        menu();
        
    }
    
    public void esc(Group root) {
        if(running){
            gl.stop();
            running = false;
            pauseMenu(root);
        }
        else {
            gl.start();
            running = true;
        }
    }
    
    public void paint(GraphicsContext gc) {
        
    }
    
    
    /**
     * main-method calls JavaFX launch(args) which starts the application (see Application)
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
//    public void endLevel(int pScore, int pHp) {
//        GraphicsContext gc = cnvs.getGraphicsContext2D();
//        gc.setFill(Color.LAWNGREEN);
//        gc.setFont(new Font("Arial", 100));
//        gc.fillText("You won", 400, 200);
//        running = false;
//    }
    
    private void menu() {
        Group root = new Group();
        root.getChildren().removeAll();
        stage.setTitle("Jump");
        stage.setResizable(false);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        Pane pane = new Pane();
        VBox mainMenu = new VBox();
        mainMenu.setSpacing(10);
        
        Button selectLevel = new Button("Select Level");
        selectLevel.setMinWidth(WIDTH/10);
        selectLevel.setMinHeight(HEIGHT/10);
        selectLevel.setStyle("-fx-background-color:\n" +
                            "linear-gradient(#f0ff35, #a9ff00),\n" +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);"
                        );
        Button exit = new Button("End");
        exit.setMinWidth(WIDTH/10);
        exit.setMinHeight(HEIGHT/10);
        exit.setStyle("-fx-background-color:\n" +
                            "linear-gradient(#f0ff35, #a9ff00),\n" +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);"
                        );
        
        
        
        mainMenu.getChildren().add(selectLevel);
        mainMenu.getChildren().add(exit);
        
        root.getChildren().add(mainMenu);
        
        stage.setScene(scene);
        stage.show();
        
        selectLevel.setOnAction(e -> {
            play();
        });
        exit.setOnAction(e -> System.exit(0));
    }
    
    /**
     * initializes and instance of Handler and and instance of KeyInput
     * initializes the game-objects
     */
    private void initGame(Group root) {
        handler = new Handler();
        keyListener = new KeyInput(handler, root, this);
        texture = new Texture();
        
        new Level(handler, this);
        //handler.add(new Player(200, 300, 64, 128, handler, this, ID.PLAYER));
        cam = new Camera(200, 300, handler); //add Level.getStart() to get levels start point for the camera
    }
    
    public void pauseMenu(Group root) {
        if(running){
            gl.stop();
            running = false;
            BoxBlur bb = new BoxBlur();
            bb.setWidth(WIDTH);
            bb.setHeight(HEIGHT);
            bb.setIterations(20);
            root.getChildren().get(0).setEffect(bb);
            
            VBox pauseMenu = new VBox();
            pauseMenu.setSpacing(10);

            Button resume = new Button("Resume");
            resume.setMinWidth(WIDTH/10);
            resume.setMinHeight(HEIGHT/10);
            resume.setStyle("-fx-background-color:\n" +
                                "linear-gradient(#f0ff35, #a9ff00),\n" +
                                "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);"
                            );
            Button back = new Button("Back to Menu");
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
            pauseMenu.getChildren().add(back);
            pauseMenu.getChildren().add(exit);

            pauseMenu.setLayoutX(WIDTH/2 - resume.getMinWidth());
            root.getChildren().add(pauseMenu);

            resume.setOnAction(e -> {
                pauseMenu.getChildren().removeAll(); //unneccessary but just for fun to get everything clean
                root.getChildren().remove(pauseMenu);
                root.getChildren().get(0).setEffect(null);
                gl.start();
                running = true;
            });
            back.setOnAction(e -> {
                menu();
            });
            exit.setOnAction(e -> System.exit(0));
            }
        else {

        }
    }
    
    private void play() {
        Group root = new Group();
        Canvas cnvs;
        root.getChildren().removeAll();
        initGame(root);
        
        stage.setTitle("Jump");
        stage.setResizable(false);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
                
        cnvs = new Canvas();
        cnvs.setHeight(HEIGHT);
        cnvs.setWidth(WIDTH);
        System.out.println(cnvs.getLayoutBounds() + "" + HEIGHT);
        GraphicsContext gc = cnvs.getGraphicsContext2D();
        paint(gc);
        root.getChildren().add(cnvs);
        //System.out.println(root.getChildren().indexOf(cnvs)); //cnvs has always index 0
                
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> keyListener.keyPressed(event.getCode()));
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> keyListener.keyReleased(event.getCode()));
        
        stage.setScene(scene);
        stage.show();
        
        gl = new GameLoop(handler, cam, gc);
        gl.start();
        running = true;
    }
    
//    private void selectLevel() {
//        
//        
//    }
    
    
    public static Texture getTexture() {
        return texture;
    }
        

}
