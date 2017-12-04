/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jump;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Silas Mueller
 */
public class Display extends Application{
    /*Display width*/
    private final int WIDTH = 1920;
    /*Display height in relation to display height (Realtion 16/9 (WIDTH/HEIGHT))*/
    private final int HEIGHT = WIDTH * (9/16);
    
    @Override
    public void start(Stage gameStage) {        
        
        gameStage.setTitle("Hello World!");
        gameStage.show();
        
        new Game(WIDTH, HEIGHT);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
