package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.Game;
import ui.PauseOverlay;


public class Playing implements Statemethods{
    private PauseOverlay pauseOverlay;
    private static boolean paused=false;
    public Game game;
    //playing state
    public Playing(Game game) {
        this.game=game;
        //player=new Player(200,400);
        pauseOverlay=new PauseOverlay(game); //creating pause overlay which is hidden by default
    }

    public void update() {
        if(paused)
            pauseOverlay.update();
    }

    public void draw(Graphics g) {
        if(paused)
            pauseOverlay.draw(g);
        
    }
    //handling menu mouse
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        if(paused)
            pauseOverlay.mousePressed(e);
    }


    public void mouseReleased(MouseEvent e) {
        if(paused)
            pauseOverlay.mouseReleased(e);
    }

    public void mouseMoved(MouseEvent e) {
        if(paused)
            pauseOverlay.mouseMoved(e);
    }
    
    public void mouseEntered(MouseEvent e) {
        
    }

    
    public void mouseExited(MouseEvent e) {
        
    }

    
    public void mouseDragged(MouseEvent e) {
        
    }
    //handling menu keyboard
    public void keyPressed(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
        
        switch(e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                paused=!paused;
        }
        
    }
    public void keyTyped(KeyEvent e){
        
    }

    public static void setPaused(boolean val){
        paused=val;
    }
    
}