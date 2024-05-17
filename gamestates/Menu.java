package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import audio.AudioPlayer;
import main.Game;
import ui.MenuButton;
import utilz.LoadSave;

public class Menu implements Statemethods{
    public Game game;
    private final MenuButton[] buttons=new MenuButton[3];
    /*game menu */
    public Menu(Game game) {
        this.game=game; //creating 3 buttons
        buttons[0]=new MenuButton(LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS), 330, 400, Gamestate.OPTIONS,0);
        buttons[1]=new MenuButton(LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS), 630 , 400, Gamestate.PLAYING,1);
        buttons[2]=new MenuButton(LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS), 930, 400, Gamestate.QUIT,2);
    }

    public void draw(Graphics g) {
        g.drawImage(LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND), 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
        g.drawImage(LoadSave.GetSpriteAtlas(LoadSave.LOGO), Game.GAME_WIDTH/2-500, -300, null);
        g.drawImage(LoadSave.GetSpriteAtlas(LoadSave.FIRMA), 1200, 760, null);
        for (MenuButton mb: buttons)
            mb.draw(g);

    }
    public void update() {
        for (MenuButton mb: buttons)
            mb.update();
    }
    //handling mouse on menu
    public void mousePressed(MouseEvent e) {
        for (MenuButton mb : buttons){
            if(mb.getBounds().contains(e.getX(), e.getY())){
                mb.setMousePressed(true);
                break;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        for (MenuButton mb : buttons){
            if(mb.getBounds().contains(e.getX(), e.getY())){
                if(mb.getMousePressed()){
                    if(mb.getState()==Gamestate.PLAYING){
                        game.getAudioPlayer().playSong(AudioPlayer.LEVELTEST);
                        Playing.setPaused(false);
                    }
                    mb.setGameState();
                }  
                break;
            }
        }
        for (MenuButton mb: buttons){
            mb.setMousePressed(false);
        }
    }

    public void mouseMoved(MouseEvent e) {
        for (MenuButton mb: buttons){
            mb.setMouseOver(false);
        }
        for (MenuButton mb: buttons){
            if(mb.getBounds().contains(e.getX(), e.getY())){
                mb.setMouseOver(true);
                break;
            }
        }
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
    public void mouseClicked(MouseEvent e) {

    }
    
}
