package game.player.item;

import game.GameObject;
import game.opition.Settings;
import game.physics.BoxCollider;
import game.player.Player;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class Item extends GameObject {
    Clip audio;
    public Item(){
        hitBox = new BoxCollider(this,32,32);
    }

    public void sound(){
        audio = AudioUtils.getSound("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\audio\\item.wav");
        AudioUtils.reply(audio);
    }

    @Override
    public void reset() {
        super.reset();
        AudioUtils.reply(audio);
    }

    @Override
    public void run() {
        super.run();
        deactiveIfNeeded();
    }
    private void deactiveIfNeeded() {
        if (this.position.y > Settings.GAME_HEIGHT+30);
    }
    public void powerUp(Player player){
    }

}
