package Jump;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Silas Mueller
 */
public class Game implements Runnable{
    
    /*Display width*/
    private int WIDTH;
    /*Display height in relation to display height (Realtion 16/9 (WIDTH/HEIGHT))*/
    private int HEIGHT;
    /*True if gameloop is running*/
    private boolean running = false;
    /*Gamethread*/
    private Thread t;
    /**
     * Handler (the handler contains a list with all game opjects and can manage them)
     */
    private Handler h;
    
    /**
     * Game Constructor
     * @param pWidth width of display
     * @param pHeight height of display
     * starts the gameloop.
     */
    
    public Game(int pWidth, int pHeight) {
        this.WIDTH = pWidth;
        this.HEIGHT = pHeight;
       start(); 
        
        h = new Handler();
    }
    
    /**
     * starts the gameloop in a new thread
     */
    
    public synchronized void start() {
        t = new Thread(this);
        t.start();
        running = true;
    }
    
    /**
     * interrupts the gameloop thread and with it the gameloop 
     */
    
    public synchronized void stop() {
        try {
            t.join();
            running = false;
        }
        catch(InterruptedException e) {
        }    

    }
    
    /**
     * Gameloop method
     * Gameloop let the game update 60 times per second and renders the frames as often as possible.
     */
    
    @Override
    public void run() {
        /**
         * Starttime nanoseconds timestamp
         */
        long startTime = System.nanoTime();
        /*Targeted FPS*/
        double targetedFPS = 60;
        /**
         * 1000000000ns is one second devided by targeted fps of a second in nanoseconds
         */
        double ns = 1000000000 / targetedFPS;
        /**
         * frame counter
         */
        int frames = 0;
        /**
         * Difference between frames
         */
        double difference = 0;
        /**
         * Timer to print FPS
         */
        long timer = System.currentTimeMillis();
        
        /**
         * Game renders as often as it can and ticks 60 times per second if possible
         */        
        
        while(running) {
            /**
             * Actual system time stamp in milliseconds
             */
            long now = System.nanoTime();
            difference = difference + (now - startTime) /ns;
            startTime = now;
            while(difference >= 1) {
                tick();
                difference--;
            }
            if(running) {
                render();
            }
            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer = timer + 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick() {
        h.tick();
        
    }
    
    private void render() {
        h.render(/*something like graphics g in javaFX*/);
        
    }
    
    
}
