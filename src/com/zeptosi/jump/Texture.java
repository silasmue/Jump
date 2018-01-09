/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import javafx.scene.image.Image;

/**
 *
 * @author news
 */
public class Texture {
    Image texture[] = new Image[2];
    
    public Texture() {
        texture[0] = new Image(getClass().getResourceAsStream("/com/zeptosi/jump/resources/img/skull.png")); //source https://www.flaticon.com/free-icon/human-skull_63928#term=skull&page=1&position=11
        texture[1] = new Image(getClass().getResourceAsStream("/com/zeptosi/jump/resources/img/block.png")); //source https://opengameart.org/content/simple-hand-painted-rock-texture-stonetexturelowdetaillight1png
    }
    
    /**
     * 
     * @return texture of the block game
     */
    public Image getBlock() {
        return texture[1];
    }
    public Image getSkull() {
        return texture[0];
    }
}
