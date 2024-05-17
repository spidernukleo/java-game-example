package ui;

import gamestates.Gamestate;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuButton {
    //menu button object, i used this both on menu and pause overlay
    private int xPos, yPos, rowIndex, index, WIDTH=200, HEIGHT=75;
    private Gamestate state;
    private BufferedImage temp;
    private BufferedImage[] imgs;
    private Rectangle bounds;
    private boolean mousePressed, mouseOver;
    public MenuButton(BufferedImage temp, int xPos, int yPos, Gamestate state, int rowIndex){
        this.xPos=xPos;
        this.yPos=yPos;
        this.state=state;
        this.temp=temp;
        this.rowIndex=rowIndex;
        bounds=new Rectangle(xPos, yPos, WIDTH, HEIGHT);
        loadImgs();
    }
    public void loadImgs(){ //2 imgs array for hover animation
        imgs = new BufferedImage[2];
        for(int i=0; i<imgs.length;i++){
            imgs[i]=temp.getSubimage(i*WIDTH, rowIndex*HEIGHT, WIDTH, HEIGHT);
        }
    }
    public void draw(Graphics g){
        g.drawImage(imgs[index], xPos, yPos, WIDTH, HEIGHT, null);
    }
    public void update(){
        index=0;
        if(mouseOver){
            index=1;
        }
            
    }
    public void setGameState(){
        Gamestate.state=state;
    }
    //mouse on buttons
    public void setMousePressed(boolean mousePressed){
        this.mousePressed=mousePressed;
    }
    public void setMouseOver(boolean mouseOver){
        this.mouseOver=mouseOver;
    }
    public Gamestate getState(){
        return state;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public boolean getMouseOver(){
        return mouseOver;
    }
    public boolean getMousePressed(){
        return mousePressed;
    }
    

}
