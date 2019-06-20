package game.player.item;

import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.Renderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemSpeed extends Item{
    public ItemSpeed(){
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Item\\speedmini.png");
        renderer = new Renderer(image);
        hitBox = new BoxCollider(this,15,15);
        this.position.set(48,302);

    }

    @Override
    public void powerUp(Player player) {
        Player.playerSpeed++;
    }

    @Override
    public void sound() {
        super.sound();
    }

    @Override
    public void reset() {
        super.reset();
    }
}
