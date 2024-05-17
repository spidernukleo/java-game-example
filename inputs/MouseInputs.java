package inputs;

import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamestates.Gamestate;

public class MouseInputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }
    //each state has its own mouse methods
    @SuppressWarnings("incomplete-switch")
    public void mouseClicked(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().mouseClicked(e);
            case CREDITS -> gamePanel.getGame().getCredits().mouseClicked(e);
            case MENU -> gamePanel.getGame().getMenu().mouseClicked(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().mouseClicked(e);
            }
    }

    @SuppressWarnings("incomplete-switch")
    public void mousePressed(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().mousePressed(e);
            case CREDITS -> gamePanel.getGame().getCredits().mousePressed(e);
            case MENU -> gamePanel.getGame().getMenu().mousePressed(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().mousePressed(e);
        }
    }

    @SuppressWarnings("incomplete-switch")
    public void mouseReleased(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().mouseReleased(e);
            case CREDITS -> gamePanel.getGame().getCredits().mouseReleased(e);
            case MENU -> gamePanel.getGame().getMenu().mouseReleased(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().mouseReleased(e);
        }
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    public void mouseEntered(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().mouseEntered(e);
            case CREDITS -> gamePanel.getGame().getCredits().mouseEntered(e);
            case MENU -> gamePanel.getGame().getMenu().mouseEntered(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().mouseEntered(e);
        }
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    public void mouseExited(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().mouseExited(e);
            case CREDITS -> gamePanel.getGame().getCredits().mouseExited(e);
            case MENU -> gamePanel.getGame().getMenu().mouseExited(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().mouseExited(e);
        }
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    public void mouseDragged(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().mouseDragged(e);
            case CREDITS -> gamePanel.getGame().getCredits().mouseDragged(e);
            case MENU -> gamePanel.getGame().getMenu().mouseDragged(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().mouseDragged(e);
        }
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Gamestate.state) {
            case PLAYING -> gamePanel.getGame().getPlaying().mouseMoved(e);
            case CREDITS -> gamePanel.getGame().getCredits().mouseMoved(e);
            case MENU -> gamePanel.getGame().getMenu().mouseMoved(e);
            case OPTIONS -> gamePanel.getGame().getGameOptions().mouseMoved(e);
        }
    }
}
