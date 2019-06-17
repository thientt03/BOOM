package game.player;

import game.GameObject;
import game.Scene.SceneGameover;
import game.Scene.SceneManager;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class PlayerExplosion extends GameObject {

    public PlayerExplosion(){

    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new SceneGameover());
    }
}
