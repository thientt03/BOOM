package game.player;

import game.GameObject;
import game.Scene.SceneGameover;
import game.Scene.SceneManager;
import game.renderer.Renderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class PlayerExplosion extends GameObject {
    Clip audio;

    public PlayerExplosion(){
        audio = AudioUtils.getSound("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\audio\\die.wav");
        AudioUtils.reply(audio);
    }

    @Override
    public void reset() {
        super.reset();
        AudioUtils.reply(audio);
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new SceneGameover());
    }
}
