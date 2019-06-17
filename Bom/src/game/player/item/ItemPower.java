package game.player.item;

import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemPower extends Item{
    public ItemPower(){
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Item\\super.png");
        renderer = new Renderer(image);
        this.hitBox = new BoxCollider(this,30,30);
        this.position.set(48,270);
    }

    @Override
    public void powerUp(Player player) {
        Player.boom += 2;
    }
}
