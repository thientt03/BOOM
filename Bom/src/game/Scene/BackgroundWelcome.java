package game.Scene;

import game.GameObject;
import game.opition.GameWindow;
import game.opition.Settings;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;


public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome(){
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\w.png");
        this.renderer = new Renderer(image);
        this.position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
    }

    @Override
    public void run(){
        if(GameWindow.isAnyKeyPress){
            super.run();
            SceneManager.signNewScene(new SceneStage1());
        }
    }

}
