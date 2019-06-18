package game.player;

import game.physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class Down extends DirectionExplosion {
    PlayerBullet explosion;
    Clip audio;

    public Down(){
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\explosions\\down", true);
        hitBox = new BoxCollider(this, 10,10);
        audio = AudioUtils.getSound("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\audio\\boom_bang.wav");
        AudioUtils.reply(audio);

    }

    @Override
    public void reset() {
        super.reset();
        AudioUtils.reply(audio);
    }
}
