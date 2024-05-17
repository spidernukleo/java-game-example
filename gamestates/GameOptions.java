package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


import main.Game;
import utilz.LoadSave;

public class GameOptions implements Statemethods{
    public Game game;
    public GameOptions(Game game) {
        this.game=game;
    }
    //game options state to use for settings of game (volume, graphics, keys..)
    public void update() {
    }

    public void draw(Graphics g) {
        g.drawImage(LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND), 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        g.drawImage(LoadSave.GetSpriteAtlas(LoadSave.FIRMA), 1200, 760, null);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }


    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
        
    }

    
    public void mouseExited(MouseEvent e) {
        
    }

    
    public void mouseDragged(MouseEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e){
        
    }
    
}
