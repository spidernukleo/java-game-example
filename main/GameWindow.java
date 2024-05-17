package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow {
    private JFrame jframe;
    /*creating window */
    public GameWindow(GamePanel gamePanel){
        jframe=new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setTitle("Space Defenders");
        jframe.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        jframe.setResizable(false);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.addWindowFocusListener(new WindowFocusListener(){
            public void windowLostFocus(WindowEvent e){
                gamePanel.getGame().pause(); //if lost focus, set paused
            }
            public void windowGainedFocus(WindowEvent e){
                //what to do when gained focus
            }
        });
    }
}
