package entities;

import java.awt.Graphics;
import java.awt.event.MouseEvent;



public class Player extends Entity{
    
    //player object
    public Player(float x, float y){
        super(x, y);
    }
    public void update(){
        
    }
    public void render(Graphics g){
        //g.drawImage(LoadSave.GetSpriteAtlas(LoadSave.PLAYER), (int)x, (int)y,  null);
    }
    public void mouseMoved(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        
    }
}
