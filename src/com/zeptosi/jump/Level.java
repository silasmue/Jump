/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

/**
 *
 * @author Silas Müller
 */
public class Level {
    private int width;
    private int height;
    private Handler handler;
    private Game game;
    
    /**
     * 
     * @param pWidth level width in 32x32 blocks (lenght)
     * @param pHeight level heught in 32x32 blocks (heightSS)
     */
    public Level(int pWidth, int pHeight, Handler pHandler) {
        handler = pHandler;
        width = pWidth;
        height = pHeight;
        testLevel();
    }
    
    public Level(Handler pHandler, Game pGame) {
        handler = pHandler;
        game = pGame;
        Image level = new Image("/com/zeptosi/jump/resources/level/level1.png");
        width = (int)level.getWidth();
        height = (int)level.getHeight();
        PixelReader pr = level.getPixelReader();
        
        boolean playerCreated = false;
        
        /*RGB-Decode Algorithmus (https://www.youtube.com/watch?v=1TFDOT1HiBo&list=PLWms45O3n--54U-22GDqKMRGlXROOZtMx&index=11)*/
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int pixel = pr.getArgb(x, y);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if(red == 0 && green == 0 && blue == 0){
                    handler.add(new Block((double)x * 64, (double)y * 64, 64, 64, ID.BLOCK)); //Black Block
                }
                if(red == 0 && green == 0 && blue == 255 && !playerCreated){
                    handler.add(new Player(x * 64, y * 64, 64, 120, handler, game, ID.PLAYER)); //Blue player
                    playerCreated = true;
                }
                if(red == 0 && green == 255 && blue == 0) {
                    handler.add(new Turtle(x*64, y*64, handler, ID.ENEMY)); //Green Turtle
                }
                if(red == 255 && green == 255 && blue == 0) {
                    handler.add(new Coin(x * 64 + 32, y * 64 + 32, ID.COIN)); //Yellow Coind
                }
//                if(red == 255 && green == 0 && blue == 0) {
//                    handler.add(new Haunter(x * 64, y * 64, handler, ID.ENEMY)); //Red Haunter
//                }
                if(red == 255 && green == 0 && blue == 255) {
                    handler.add(new Patrol(x * 64, y * 64, handler, ID.ENEMY)); //Purple Patrol
                }
                if(red == 0 && green == 255 && blue == 255) {
                    handler.add(new End(x * 64, y * 64, ID.END)); //BlueGreen End
                }
                
            }
        }
    }
    
    private void testLevel() {
        for(int x = 0; x < width; x++) {
                handler.add(new Block((double)x * 64, (double)14 * 64, (double)64, (double)64, ID.BLOCK));
                handler.add(new Block(x * 64, 15 * 64, 64, 64, ID.BLOCK));
        }
        
        for(int y = 0; y < height; y++) {
                handler.add(new Block(0 * 64, y * 64, 64, 64, ID.BLOCK));
        }
        
        for(int x = 10; x < 20; x++) {
                handler.add(new Block(x * 64, 10 * 64, 64, 64, ID.BLOCK));
        }
        
        for(int x = 5; x < 10; x++) {
                handler.add(new Coin(x * 2 * 64, 13.5 * 64, ID.COIN));
        }
        
        handler.add(new Block( 24 * 64, 13 * 64, 64, 64, ID.BLOCK));
        handler.add(new Block( 34 * 64, 13 * 64, 64, 64, ID.BLOCK));
        handler.add(new Turtle(25 * 64, 8 * 64, handler, ID.ENEMY));
        handler.add(new Patrol(11 * 64, 9 * 64, handler, ID.ENEMY));
        handler.add(new Haunter(3 * 64, 13 * 64, handler, ID.ENEMY));
        handler.add(new End(38 * 64, 8 * 64, ID.END));

    }
    
    private void getLevel() {
        
        
    }
    
}
