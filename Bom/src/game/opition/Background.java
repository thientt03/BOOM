package game.opition;

import game.GameObject;
import game.renderer.Renderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class Background extends GameObject {
    Clip audio;
    public  Background(){
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Map\\hiuhiu.jpg");
        renderer = new Renderer(image);
        audio = AudioUtils.getSound("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\audio\\soundGame.wav");
        AudioUtils.reply(audio);
        AudioUtils.loopForever(audio);
    }

    @Override
    public void reset() {
        super.reset();
        AudioUtils.reply(audio);
    }
}
