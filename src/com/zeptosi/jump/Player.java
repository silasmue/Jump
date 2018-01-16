/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeptosi.jump;

import java.util.LinkedList;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

/**
 *
 * @author Silas Müller
 */
public class Player extends GameObject{
    private Rectangle player;
    private Handler handler;
    private Game game;
    
    private double lastX;
    private double lastY;
    
    private boolean jumping, falling;
    private double gravity = 0.5;
    
    private int health;
    private int coins;
    private int vulnerable;
    private int score;
    private boolean won = false;
    
    private Random r;
    
    
    public Player(double pX, double pY, double pWidth, double pHeight, Handler pHandler, Game pGame, ID pID) {
        super(pID);
        handler = pHandler;
        game = pGame;
        player = new Rectangle(pX, pY, pWidth, pHeight);
        player.setFill(Color.RED);
        player.setArcHeight(0);
        player.setArcWidth(0);
        falling = true;
        jumping = true;
        
        health = 100;
        vulnerable = 90; //player can be damaged = 90 for 1.5s (60ticks per second)
        score = 0;
        r = new Random();
    }

    @Override
    public void tick() {
        if(falling || jumping) {
            velY += gravity;
        }
        if(vulnerable < 90) {
            vulnerable++;
        }
        
        LinkedList<GameObject> gO = handler.getClosest(getX(), getY());
        LinkedList<GameObject> toRemove = new LinkedList();
        
        setX(getX() + velX);
        for(int i = 0; i < gO.size(); i++) { //can not use enhanced for-loop because we are deleting and element of the LinkedList
                if(Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velX > 0) {
                        if(gO.get(i).getID() == ID.ENEMY && vulnerable == 90) {
                            health -= 20;
                            vulnerable = 0;
                        }
                        if(gO.get(i).getID() == ID.COIN) {
                            coins++;
                            handler.remove(gO.get(i));
                            gO.remove(gO.get(i));
                            //i--;
                        }
                        if(gO.get(i).getID() == ID.BLOCK) {
                            setX(getX() - Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth());
                        }
                        
                    }
                    if(velX < 0) {
                        if (gO.get(i).getID() == ID.ENEMY && vulnerable == 90) {
                            health -= 20;
                            vulnerable = 0;
                        }
                        if(gO.get(i).getID() == ID.COIN) {
                            coins++;
                            handler.remove(gO.get(i));
                            gO.remove(gO.get(i));
                            //i--; //to not miss somthing //Herr Krieg fragen
                        }
                        if(gO.get(i).getID() == ID.BLOCK) {
                            setX(getX() + Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth());
                        }
                        if(gO.get(i).getID() == ID.END) {
                            score += 1111;
                            game.won();
                        }
                    }
                }
        }
        //handler.removeAll(toRemove);
        //toRemove.clear();
        
        setY(getY() + velY);
        falling = true; //to make player not jump when falling down 
        jumping = true;
        for(int i = 0; i < gO.size(); i++) { //can not use enhanced for-loop because we are deleting and element of the LinkedList
                if(Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getWidth() != -1){
                    if(velY > 0) { // collision on bot side of the player
                        if(gO.get(i).getID() == ID.ENEMY && vulnerable == 90) {
                            Enemy e = (Enemy) gO.get(i);
                            health -= 20;
                            vulnerable = 0;
                            if(jumping || falling) { //noch nicht schoen spaeter fixen
                                health += 20;
                                vulnerable = 90;
                                score += e.getKillScore();
                                toRemove.add(gO.get(i)); //nicht sicher ob remove(e) auch geht
                                gO.remove(gO.get(i));
                                //i--;
                            }
                        }
                        if(gO.get(i).getID() == ID.COIN) {
                            coins++;
                            handler.remove(gO.get(i));
                            gO.remove(gO.get(i));
                            //i--; //to not miss somthing //Herr Krieg fragen
                        }
                        if(gO.get(i).getID() == ID.BLOCK) {
                            setY(getY() - Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getHeight());
                            falling = false;
                            jumping = false;
                        }
                        if(gO.get(i).getID() == ID.END) {
                            score += 1111;
                            game.won();
                        }
                    }
                    if(velY < 0) {
                        if(gO.get(i).getID() == ID.ENEMY && vulnerable == 90) {
                            health -= 20;
                            vulnerable = 0;
                        }
                        if(gO.get(i).getID() == ID.COIN) {
                            coins++;
                            handler.remove(gO.get(i));
                            gO.remove(gO.get(i));
                            //i--;
                        }
                        if(gO.get(i).getID() == ID.BLOCK) {
                            setY(getY() + Shape.intersect(player, gO.get(i).getHitbox()).getBoundsInParent().getHeight());
                            velY = 0;
                            falling = true;
                            jumping = true;
                        }
                        if(gO.get(i).getID() == ID.END) {
                            score += 1111;
                            game.won();
                        }
                    }
            }
        }
        handler.removeAll(toRemove);
        toRemove.clear();
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(getX(), getY(), getWidth(), getHeight());
        
        if(health <= 0) {
            gc.setFont(new Font("Arial", 172)); //geht noch nicht
            gc.setFill(Color.ORANGE);
            gc.fillText("YOU DIED", 400, 200);
            game.die();
        }
        
        if(won) {
            gc.setFont(new Font("Arial", 172)); //geht noch nicht
            gc.setFill(Color.ORANGE);
            gc.fillText("YOU WON", 400, 200);
            score += 1111;
            game.won();
        }
    }

    @Override
    public double getX() {
        return player.getBoundsInParent().getMinX();
    }

    @Override
    public void setX(double x) {
        player.setX(x);
    }

    @Override
    public double getY() {
        return player.getBoundsInParent().getMinY();
    }

    @Override
    public void setY(double y) {
        player.setY(y);       
    }
    
    @Override
    public Shape getHitbox() {
        return player;
    }
    
    public boolean isJumping() {
        return jumping;
    }
    
    public void jump() {
        jumping = true;
    }

    public double getLastX() {
        return lastX;
    }

    public void setLastX(double lastX) {
        this.lastX = lastX;
    }

    public double getLastY() {
        return lastY;
    }

    public void setLastY(double lastY) {
        this.lastY = lastY;
    }
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public double getWidth() {
        return player.getWidth();
    }
    
    public double getHeight() {
        return player.getHeight();
    }
    
    public int getCoins() {
        return coins;
    }
    
    public int getScore() {
        return score;
    }

    public void givePoints(double points) {
        score += points;
    }
    
}