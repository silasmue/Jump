/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Silas Müller
 */
public class Physics {

        public static Direction checkCollision(Shape object, Shape partner) {
            
        if (Shape.intersect(object, partner).getBoundsInParent().getWidth() != -1) {
            
            return Direction.COLLISION;
        }
        else {
            return Direction.NONE;
        }
        
    }
        
    private static Rectangle getBottom(Shape pObject) {
        Rectangle bottom = new Rectangle();
                bottom.setX(pObject.getBoundsInParent().getMinX() + 11); //Max velocity of player + 1
                bottom.setY(pObject.getBoundsInParent().getMinY() + pObject.getBoundsInParent().getHeight()/2);
                bottom.setHeight(pObject.getBoundsInParent().getHeight()/2); //Half height of player
                bottom.setWidth(pObject.getBoundsInParent().getWidth()); //Player width - (2 times max velocity + 2)
                bottom.setArcHeight(0);
                bottom.setArcWidth(0);
        return bottom;
    }
    
    private static Rectangle getTop(Shape pObject) {
        Rectangle top = new Rectangle();
                top.setX(pObject.getBoundsInParent().getMinX() + 11); //Max velocity of player + 1
                top.setY(pObject.getBoundsInParent().getMinY()); //starts at the top of the player
                top.setHeight(pObject.getBoundsInParent().getHeight()/2); //Half height of player
                top.setWidth(pObject.getBoundsInParent().getWidth() - 22); //Player width - (2 times max velocity + 2)
                top.setArcHeight(0);
                top.setArcWidth(0);
        return top;
    }
    
    private static Rectangle getLeft(Shape pObject) {
        Rectangle left = new Rectangle();
                left.setX(pObject.getBoundsInParent().getMinX()); //strats at top left of the player
                left.setY(pObject.getBoundsInParent().getMinY() + 11); ///Max velocity of player + 1
                left.setHeight(pObject.getBoundsInParent().getHeight()); //full hight to cover complete side
                left.setWidth(11); //player max velocity + 1
                left.setArcHeight(0);
                left.setArcWidth(0);
        return left;
    }
    
    private static Rectangle getRight(Shape pObject) {
        Rectangle right = new Rectangle();
                right.setX(pObject.getBoundsInParent().getMaxX() - 11); //strats at top right of the player 11 pixels width because of maxvelocity
                right.setY(pObject.getBoundsInParent().getMinY()); ///Max velocity of player + 1
                right.setHeight(pObject.getBoundsInParent().getHeight()); //full hight to cover complete side
                right.setWidth(11); //player max velocity + 1
                right.setArcHeight(0);
                right.setArcWidth(0);
        return right;
    }
    
}

    
