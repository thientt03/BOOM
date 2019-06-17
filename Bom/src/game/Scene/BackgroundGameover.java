//package game.Scene;
//
//import game.GameObject;
//import game.opition.Settings;
//import game.renderer.Renderer;
//import tklibs.SpriteUtils;
//
//import java.awt.image.BufferedImage;
//
//public class BackgroundGameover extends GameObject {
//    public BackgroundGameover(){
////        GameObject.botLayer.add(this);
//
//        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Minion_Up\\up1.png");
//        this.renderer = new Renderer(image);
//        this.position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
//    }
//}
package game.Scene;

import game.GameObject;
import game.opition.GameWindow;
import game.opition.Settings;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundGameover extends GameObject {
    public BackgroundGameover(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/backgpund/vemenu (1).png");
        this.renderer = new Renderer(image);
        this.position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
    }

    @Override
    public void run(){
        if(isMouseOnButton1()) {
            if (GameWindow.mouseClicked) {
                SceneManager.signNewScene(new SceneStage1());
                GameWindow.mouseClicked = false;
            }
        }
    }

    private boolean isMouseOnButton1() {
        double x = Settings.mousePosition.x;
        double y = Settings.mousePosition.y;
        return x > 382 && x < 443 && y > 430 && y < 484;
    }
}
