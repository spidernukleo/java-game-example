package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import audio.AudioPlayer;
import gamestates.Gamestate;
import gamestates.Playing;
import main.Game;
import utilz.LoadSave;

public class PauseOverlay {
    private BufferedImage background;
    private final MenuButton[] buttons=new MenuButton[3];
    private int bgX, bgY, bgW, bgH;
    private Game game;
    //pause menu
    //this gets shown only on playing state when paused=true, it's an overlay
    public PauseOverlay(Game game){
        this.game=game;
        loadBackground();
        loadButtons();
    }
    public void update(){
        for (MenuButton mb: buttons)
            mb.update();
    }
    public void draw(Graphics g){
        g.drawImage(background, bgX, bgY, bgW, bgH, null);
        for (MenuButton mb: buttons)
            mb.draw(g);
    }
    private void loadBackground(){
        background= LoadSave.GetSpriteAtlas(LoadSave.PAUSEDOVERLAY);
        bgW = (int) (background.getWidth() * 1.3);
		bgH = (int) (background.getHeight() * 1.3);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = 200; //positioning the overlay correctly
    }
    private void loadButtons(){ //same buttons used in normal menu but with different position etc..
        buttons[0]=new MenuButton(LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS), (Game.GAME_WIDTH/2-100), 340, Gamestate.PLAYING,3);
        buttons[1]=new MenuButton(LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS), (Game.GAME_WIDTH/2-100), 440, Gamestate.OPTIONS,0);
        buttons[2]=new MenuButton(LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS), (Game.GAME_WIDTH/2-100), 540, Gamestate.MENU,2);
    }
    //handling mouse in pause
    public void mouseDragged(MouseEvent e){

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
                if(mb.getMousePressed())
                    if(mb.getState()==Gamestate.PLAYING)
                        Playing.setPaused(false);
                    if(mb.getState()==Gamestate.MENU)
                        game.getAudioPlayer().playSong(AudioPlayer.MENU_1);
                    mb.setGameState();
                break;
            }
        }
        for (MenuButton mb: buttons){
            mb.setMousePressed(false);
        }
    }
}
