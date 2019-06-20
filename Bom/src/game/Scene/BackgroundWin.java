package game.Scene;

import game.GameObject;
import game.opition.GameWindow;
import game.opition.Settings;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundWin extends GameObject {
    public BackgroundWin(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/backgpund/youwin.png");

        this.renderer = new Renderer(image);
        this.position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
    }

    @Override
    public void run(){
        if(isMouseOnButton1()) {
            if (GameWindow.mouseClicked) {
                SceneManager.signNewScene(new SceneStage2());
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
