package game.opition;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;



public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isAnyKeyPress;
    public static boolean isEnterPress;
    public static boolean mouseClicked = false;

    public GameWindow() {
        KeyAdapter keyHander = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                isAnyKeyPress = true;
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                isAnyKeyPress = false;
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isFirePress = false;
                }
            }
        };
        addKeyListener(keyHander);
        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseClicked = true;
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                double x = e.getX() - getInsets().left;
                double y = e.getY() - getInsets().top;
                Settings.mousePosition.set(x, y);
            }
        };
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);





    }
}
