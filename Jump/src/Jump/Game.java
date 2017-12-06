/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jump;

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
    
    private final int WIDTH = 1920;
    private final int HEIGHT = WIDTH * (9/16);
    
    private Handler handler;
    private KeyInput keyListener;

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
            @Override
            public void handle(long now) {
               handler.tick();
               handler.updateRender();
           }
        };
        at.start();
    }
            
    public static void main(String[] args) {
        launch(args);
    }
    
    private void initGame() {
        handler = new Handler();
        keyListener = new KeyInput(handler);
        
        handler.add(new Player(200, 300, ID.Player));
    }
}
