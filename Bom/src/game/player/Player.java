package game.player;

import game.GameObject;
import game.map.Platform;
import game.opition.GameWindow;
import game.opition.Settings;
import game.opition.Vector2D;
import game.physics.BoxCollider;
import game.player.item.Item;
import game.player.level1.PlayerBullet1;
import game.renderer.Renderer;

public class Player extends GameObject {
    int hp;
    public int power;
    public int buff;
    public static int playerSpeed;

    public Player(){
        hitBox = new BoxCollider(this, 25,25);
        position.set(32+17,32+17);
        hp = 1;
        power = 1;
        playerSpeed = 1;
        buff = 1;
        if (buff == 1) {
            this.renderer = new PlayerRenderer();
        }
        else{
            this.renderer = new PlayerRenderer2();
        }
    }
    @Override
    public void run() {
        super.run();
        this.move();
        this.limit();
        this.fire();
        this.hitItem();
    }
    int Count =0;
    public static int boom = 1;
    public boolean planted = false;
    public void fire() {
        Count++;
        if (GameWindow.isFirePress && Count > 30){
            if(boom > 0) {
                planted = true;
                boom = boom-1;
                PlayerBullet bullet;
                PlayerBullet1 bullet1;
                if(power == 1) {
                    bullet = recycle(PlayerBullet.class);
                    bullet.position.set(this.position.x,this.position.y);
                    //Credit: Supporter Đặng Anh Đức :))
                    if (position.x % 16 != 0 && position.x % 32 < 16) {
                        bullet.position.x = position.x + (16 - position.x % 16);
                    } else if (position.x % 16 != 0 && position.x % 32 >= 16) {
                        bullet.position.x = position.x - position.x % 16;
                    }

                    if (position.y % 16 != 0 && position.y % 32 < 16) {
                        bullet.position.y = position.y + (16 - position.y % 16);
                    } else if (position.y % 16 != 0 && position.y % 32 >= 16) {
                        bullet.position.y = position.y - position.y % 16;
                    }
                } else {
                    // TODO: dat boom dai
                    bullet1 = recycle(PlayerBullet1.class);
                    bullet1.position.set(this.position.x,this.position.y);
                    //Credit: Supporter Đặng Anh Đức :))
                    if (position.x % 16 != 0 && position.x % 32 < 16) {
                        bullet1.position.x = position.x + (16 - position.x % 16);
                    } else if (position.x % 16 != 0 && position.x % 32 >= 16) {
                        bullet1.position.x = position.x - position.x % 16;
                    }

                    if (position.y % 16 != 0 && position.y % 32 < 16) {
                        bullet1.position.y = position.y + (16 - position.y % 16);
                    } else if (position.y % 16 != 0 && position.y % 32 >= 16) {
                        bullet1.position.y = position.y - position.y % 16;
                    }

                }
//
                Count = 0;
            }
        }
    }

    private void limit() {
        if(position.x < 32 + 16) {
            position.set(32 + 16, position.y);
        }
        if(position.x > Settings.GAME_WIDTH - (32 + 16)) {
            position.set(Settings.GAME_WIDTH - (32 + 16), position.y);
        }
        if(position.y < 32+16) {
            position.set(position.x, 32+16);
        }
        if(position.y > Settings.GAME_HEIGHT - (32 + 16)) {
            position.set(position.x, Settings.GAME_HEIGHT - (32 + 16));
        }

    }
//    int playerSpeed = 1;
    public void move() {
        double vx = 0;
        double vy = 0;
        if(GameWindow.isUpPress) {
            vy -= playerSpeed;
        }
        if(GameWindow.isDownPress) {
            vy += playerSpeed;
        }
        if(GameWindow.isLeftPress) {
            vx -= playerSpeed;
        }
        if(GameWindow.isRightPress) {
            vx += playerSpeed;
        }
        Platform wall = GameObject.findIntersects(Platform.class, this.hitBox.shift(vx, vy));

        if(wall != null) {
            Vector2D boxAheadPosition = wall.position;
            Vector2D slideThroughVector = this.trySlideThrough(boxAheadPosition, vx, vy);
            if(slideThroughVector == null) {
                vx = 0;
                vy = 0;
            } else {
                vx = slideThroughVector.x;
                vy = slideThroughVector.y;
            }
        }
        // edit>>
        velocity.set(vx, vy);
        velocity.setLength(playerSpeed);
    }
    public void hitItem() {
        Item item = GameObject.findIntersects(Item.class,this);
        if (item != null){
            item.deactive();
            item.powerUp(this);
        }
    }

    public Vector2D trySlideThrough(Vector2D boxAheadPosition, double vx, double vy) {
        double deviation = Math.abs(vx) > 0
                ? position.y - boxAheadPosition.y
                : position.x - boxAheadPosition.x;
        if(Math.abs(deviation) > 22) { // edit this number for sliding smoother
            Vector2D nextToBoxAheadPosition = boxAheadPosition.clone();
            if(Math.abs(vx) > 0) { // move horizontal, slide up/down
                nextToBoxAheadPosition.add(0, Math.signum(deviation) * 44);
            } else { // move vertical, slide left/right
                nextToBoxAheadPosition.add(Math.signum(deviation) * 44, 0);
            }
            BoxCollider nextToBoxAheadHitBox = new BoxCollider(nextToBoxAheadPosition, this.anchor, 42, 42);
            if(GameObject.findIntersects(Platform.class, nextToBoxAheadHitBox) != null) {
                return null;
            }

            Vector2D slideVector = new Vector2D(vx, vy);
            if(Math.abs(vx) > 0) {
                slideVector.y = nextToBoxAheadPosition.y - this.position.y;
            } else {
                slideVector.x = nextToBoxAheadPosition.x - this.position.x;
            }
            return slideVector;
        }
        return null;
    }

    @Override
    public void deactive() {
        super.deactive();
        PlayerExplosion playerExplosion = GameObject.recycle(PlayerExplosion.class);
        playerExplosion.position.set(this.position);
    }

}
