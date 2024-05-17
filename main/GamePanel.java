package main;

import inputs.*;
import javax.swing.*;
import java.awt.*;
import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;


public class GamePanel extends JPanel {
    /*creating mouse listener and keyboard listener */
    private Game game;
    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    public GamePanel(Game game){
        this.game=game;
        mouseInputs=new MouseInputs(this);
        keyboardInputs=new KeyboardInputs(this);
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
        requestFocus(true);
    }
    public Game getGame(){
        return game;
    }
}
