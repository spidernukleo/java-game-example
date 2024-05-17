package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamestates.Gamestate;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }
    //each state has its own keys methods
    @SuppressWarnings("incomplete-switch")
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state){
            case MENU -> gamePanel.getGame().getMenu().keyPressed(e);
            case PLAYING -> gamePanel.getGame().getPlaying().keyPressed(e);
            case CREDITS -> gamePanel.getGame().getCredits().keyPressed(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().keyPressed(e);
        }
    }

    @SuppressWarnings("incomplete-switch")
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state){
            case MENU -> gamePanel.getGame().getMenu().keyReleased(e);
            case PLAYING -> gamePanel.getGame().getPlaying().keyReleased(e);
            case CREDITS -> gamePanel.getGame().getCredits().keyReleased(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().keyReleased(e);
        }

    }
    @SuppressWarnings("incomplete-switch")
    @Override
    public void keyTyped(KeyEvent e) {
        switch (Gamestate.state){
            case MENU -> gamePanel.getGame().getMenu().keyTyped(e);
            case PLAYING -> gamePanel.getGame().getPlaying().keyTyped(e);
            case CREDITS -> gamePanel.getGame().getCredits().keyTyped(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().keyTyped(e);
        }
    }
}
