package game.player.item;

import game.physics.BoxCollider;
import game.player.Player;
import game.player.PlayerRenderer;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemSuper extends Item {
    public ItemSuper(){
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Item\\supergoku.png");
        renderer = new Renderer(image);
        hitBox = new BoxCollider(this, 30, 30);
        this.position.set(48,110);
    }

    @Override
    public void powerUp(Player player) {
        player.buff++;
    }
}
