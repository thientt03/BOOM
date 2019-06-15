package game.Scene;

import game.GameObject;
import game.opition.Settings;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundGameover extends GameObject {
    public BackgroundGameover(){
//        GameObject.botLayer.add(this);

        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Minion_Up\\up1.png");
        this.renderer = new Renderer(image);
        this.position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
    }
}
