package game.player.item;


import game.physics.BoxCollider;
import game.player.Down;
import game.player.Player;
import game.player.PlayerBullet;
import game.renderer.Renderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemBullet extends Item {

    public ItemBullet(){
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Item\\spellmini.png");
        renderer = new Renderer(image);
        this.position.set(175,50);
        hitBox = new BoxCollider(this,15,15);
    }

    @Override
    public void powerUp(Player player) {
        player.power = 2;
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
