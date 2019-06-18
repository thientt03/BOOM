package game.player.item;

import game.physics.BoxCollider;
import game.player.Player;
import game.player.PlayerRenderer;
import game.renderer.Renderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ItemSuper extends Item {
    public boolean immune;

    public ItemSuper() {
        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Item\\supergokumini.png");
        renderer = new Renderer(image);
        hitBox = new BoxCollider(this, 15, 15);
        this.position.set(143, 84);
        immune = false;
    }
    int damage = 1;
    @Override
    public void powerUp(Player player) {
//        System.out.println("Helo");
        player.buff++;
        player.renderer = player.renderer2;
        Player.starCounting = true;
        player.takeDamage(damage);
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
