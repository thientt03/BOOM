package game.player;

import game.GameObject;
import game.opition.Settings;
import game.physics.BoxCollider;
import game.renderer.Renderer;

import java.awt.*;

public class PlayerBullet extends GameObject {
    int count;
    int damage;
    boolean isExplode = false;
    Mid mid;
    Up up;
    Down down;
    Left left;
    Right right;
    public PlayerBullet(){
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
        mid = GameObject.recycle(Mid.class);
        up = GameObject.recycle(Up.class);
        down = GameObject.recycle(Down.class);
        left = GameObject.recycle(Left.class);
        right = GameObject.recycle(Right.class);
        mid.position.set(position);
        up.position.set(position.x, position.y - 22);
        down.position.set(position.x, position.y + 22);
        left.position.set(position.x - 22, position.y);
        right.position.set(position.x + 22, position.y);

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
