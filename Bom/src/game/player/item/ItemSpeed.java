package game.player.item;

import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemSpeed extends Item{
    public ItemSpeed(){
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Item\\speed.png");
        renderer = new Renderer(image);
        hitBox = new BoxCollider(this,30,30);
        this.position.set(48,210);
    }

    @Override
    public void powerUp(Player player) {
        Player.playerSpeed++;
    }
}
