package game.player;

import game.GameObject;

import game.enemy.Enemy;

public class DirectionExplosion extends GameObject {
    boolean playerDie;

    public DirectionExplosion(){
        playerDie = false;
    }

    @Override
    public void run() {
        super.run();
//        hitEnemy();
//        hitBomb();
//        hitPlayer();
    }

//    public void hitPlayer() {
//        Player player = GameObject.findIntersects(Player.class, this);
//        if (player != null) {
//           player.deactive();
//        }
//    }


//    public void hitEnemy() {
//        Enemy enemy = GameObject.findIntersects(Enemy.class,this);
//        if (enemy != null) {
//            enemy.deactive();
//        }
//    }

//    public void hitBomb() {
//        PlayerBullet playerBullet = GameObject.findIntersects(PlayerBullet.class, this);
//        if (playerBullet != null) {
//            playerBullet.explode();
//        }
//    }
}
