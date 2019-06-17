package game.enemy;

import game.GameObject;
import game.opition.Settings;
import game.physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
    public Enemy(){
        BufferedImage img = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\enemy\\boss_right_1.png");
        renderer = new Renderer(img);
        hitBox = new BoxCollider(this,32,32);
        position.set(32+16,32+16);
        velocity.set(1,0);
    }

    @Override
    public void run() {
        super.run();
        move();
    }

    private void move() {
        position.add(1,0);
        if(position.x < 50) {
            velocity.add(1,0);
        }
        if(position.x > Settings.GAME_WIDTH - 50) {
            velocity.add(-1,0);
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        EnemyExplosion enemyExplosion = GameObject.recycle(EnemyExplosion.class);
        enemyExplosion.position.set(this.position);
    }
}
