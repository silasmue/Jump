/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

/**
 *
 * @author Silas Müller <your.name at your.org>
 */
public class Level {
    private int width;
    private int height;
    private Handler handler;
    
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
    
    private void testLevel() {
        for(int x = 0; x < width; x++) {
                handler.add(new Block((double)x * 64, (double)14 * 64, (double)64, (double)64, ID.Block));
                handler.add(new Block(x * 64, 15 * 64, 64, 64, ID.Block));
        }
        
        for(int y = 0; y < height; y++) {
                handler.add(new Block(0 * 64, y * 64, 64, 64, ID.Block));
        }
        
        for(int x = 10; x < 20; x++) {
                handler.add(new Block(x * 64, 10 * 64, 64, 64, ID.Block));
        }
        
    }
    
    
    
}
