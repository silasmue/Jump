/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jump;

import java.util.LinkedList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author news
 */
public class Game extends Application{
    
    private final int WIDTH = 1920;
    private final int HEIGHT = WIDTH * (9/16);
    
    private Handler handler;

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
        
        handler.add(new Player(200, 300, ID.Player));
    }   
}
