package game.player.level1;

import game.GameObject;
import game.opition.Settings;
import game.physics.BoxCollider;
import game.player.Player;
import game.player.level1.*;
import game.renderer.Renderer;

import java.awt.*;

public class PlayerBullet1 extends GameObject {
    int count;
    int damage;
    boolean isExplode = false;
    Mid1 mid1;
    Up1 up1;
    Down1 down1;
    Left1 left1;
    Right1 right1;
    public PlayerBullet1(){
        count = 0;
        hitBox = new BoxCollider(this, 44, 44);
        damage = 1;
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Boomm");
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void run() {
        super.run();
//        limit();
        explodeTime();
    }
    int Count = 0;
    public void explodeTime() {
        Player boom = GameObject.find(Player.class);
        if (boom.planted == true){
            Count++;
            if (Count > 180) {
                this.explode();
                Count = 0;
                boom.boom += 1;
            }
        }
    }

    public void explode() {
        isExplode = true;
        this.deactive();
        mid1 = GameObject.recycle(Mid1.class);
        up1 = GameObject.recycle(Up1.class);
        down1 = GameObject.recycle(Down1.class);
        left1 = GameObject.recycle(Left1.class);
        right1 = GameObject.recycle(Right1.class);
        mid1.position.set(position);
        up1.position.set(position.x, position.y - 22);
        down1.position.set(position.x, position.y + 22);
        left1.position.set(position.x - 22, position.y);
        right1.position.set(position.x + 22, position.y);

    }

//    private void limit() {
//        if(position.x < 44) {
//            position.set(66, position.y);
//        }
//        if(position.x > Settings.GAME_WIDTH - 44) {
//            position.set(
//                    Settings.GAME_WIDTH - 66,
//                    position.y
//            );
//        }
//        if(position.y < 88) {
//            position.set(position.x, 110);
//        }
//        if(position.y > Settings.GAME_HEIGHT - 44) {
//            position.set(
//                    position.x,
//                    Settings.GAME_HEIGHT - 66
//            );
//        }
//    }
}
