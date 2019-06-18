package game.player.item;

import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.Renderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemPower extends Item{
    public ItemPower(){
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Item\\supermini.png");
        renderer = new Renderer(image);
        this.hitBox = new BoxCollider(this,15,15);
        this.position.set(48,270);
    }

    @Override
    public void powerUp(Player player) {
        Player.boom += 2;
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
