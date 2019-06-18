package game.player.level1;

import game.physics.BoxCollider;
import game.player.DirectionExplosion;
import game.renderer.Renderer;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class Down1 extends DirectionExplosion {
    Clip audio;
    public Down1(){
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\explosions\\level1\\Down", true);
        hitBox = new BoxCollider(this, 10,80);
        audio = AudioUtils.getSound("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\audio\\bomlevel1.wav");
        AudioUtils.reply(audio);
    }

    @Override
    public void reset() {
        super.reset();
        AudioUtils.reply(audio);
    }
}
