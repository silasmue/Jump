/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author news
 */
public class End extends GameObject{
    private Rectangle end;
    private Handler handler;
    public End(double pX, double pY, Handler pHandler,ID pID) {
        super(pID);
        end = new Rectangle();
        end.setX(pX);
        end.setY(pY);
        end.setWidth(64);
        end.setHeight(64);
    }

    @Override
    public void tick() {
       LinkedList<GameObject> gO = new LinkedList<GameObject>();
        //gO = handler.getGameObjects();
       
       for(GameObject o : gO) {
            
       }
    }

    @Override
    public void render(GraphicsContext gc) {
       gc.setFill(Color.DEEPPINK);
       gc.fillRect(getX(), getY(), end.getWidth(), end.getHeight());
    }

    @Override
    public double getX() {
       return end.getX();
    }

    @Override
    public void setX(double x) {
       end.setX(x);
    }

    @Override
    public double getY() {
       return end.getY();
    }

    @Override
    public void setY(double y) {
       end.setY(y);
    }

    @Override
    public Shape getHitbox() {
        return end;
    }
    
}
