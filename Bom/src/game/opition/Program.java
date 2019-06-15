package game.opition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        GamePanel panel = new GamePanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH,Settings.GAME_HEIGHT));

        window.add(panel);
        window.pack();

        window.setTitle("MindX-Boom");
        window.setLocation(500,0);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setVisible(true);
        panel.GameLoop();

    }
}
