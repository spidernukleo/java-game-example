package main;
import java.awt.Graphics;

import audio.AudioPlayer;
import gamestates.*;

public class Game implements Runnable{
    /*setting variables */
    private GamePanel gamePanel;
    private Thread gameThread;
    private Menu menu;
    private Playing playing;
    private Credits credits;
    private GameOptions gameOptions;
    private AudioPlayer audioPlayer;
	public final static int GAME_WIDTH = 1440;
	public final static int GAME_HEIGHT = 900;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private final boolean SHOW_FPS_UPS = true; //set to false to disable fps showing in console

    public Game(){
        initStates();
        gamePanel=new GamePanel(this);
        new GameWindow(gamePanel); //creating window and panel
        gamePanel.requestFocusInWindow(); 
        gameThread= new Thread(this); 
        gameThread.start(); //starting game thread
    }
    
    public void initStates(){ /*starting all game states */
        menu = new Menu(this);
        playing = new Playing(this);
        credits= new Credits(this);
        gameOptions=new GameOptions(this);
        audioPlayer = new AudioPlayer();
    }

    public void update(){ //based on which state you are in, call that state update function
        switch(Gamestate.state){
            case MENU -> menu.update();
            case PLAYING -> playing.update();
            case OPTIONS -> gameOptions.update();
            case CREDITS -> credits.update();
            case QUIT -> System.exit(0);
        }
    }
    
    @SuppressWarnings("incomplete-switch")
    public void render(Graphics g){ //based on which state you are in, call that state render function
        switch(Gamestate.state){
            case MENU -> menu.draw(g);
            case PLAYING -> playing.draw(g);
            case OPTIONS -> gameOptions.draw(g);
            case CREDITS -> credits.draw(g);
        }
    }

    @Override
    public void run() { //FPS HANDLE
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long previousTime = System.nanoTime();
        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();
        double deltaU = 0;
        double deltaF = 0;
        while (true) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;
            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }
            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            if (SHOW_FPS_UPS)
                if (System.currentTimeMillis() - lastCheck >= 1000) {
                    lastCheck = System.currentTimeMillis();
                    System.out.println("FPS: " + frames + " | UPS: " + updates);
                    frames = 0;
                    updates = 0;
                }

        }
    }
    @SuppressWarnings("incomplete-switch")
    public void pause(){
        switch(Gamestate.state){
            case PLAYING -> Playing.setPaused(true);
        }
    }
    public Menu getMenu(){
        return menu;
    }
    public Playing getPlaying(){
        return playing;
    }
    public Credits getCredits(){
        return credits;
    }
    public GameOptions getGameOptions(){
        return gameOptions;
    }
    public AudioPlayer getAudioPlayer(){
        return audioPlayer;
    }

}
