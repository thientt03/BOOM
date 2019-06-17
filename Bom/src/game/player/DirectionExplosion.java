package game.player;

import game.GameObject;

import game.enemy.Bot;
import game.enemy.Bot1;
import game.enemy.Enemy;
import game.map.Platform;
import game.player.item.Item;
import game.player.item.ItemBullet;

public class DirectionExplosion extends GameObject {
    boolean playerDie;

    public DirectionExplosion(){
        playerDie = false;
    }

    @Override
    public void run() {
        super.run();
        hitEnemy();
        hitBomb();
        hitPlayer();
        hitBlock();
    }


    public void hitPlayer() {
        Player player = GameObject.findIntersects(Player.class, this);
        if (player != null) {
           player.deactive();
        }
    }


    public void hitEnemy() {
        Bot bot = GameObject.findIntersects(Bot.class,this);
        if (bot != null) {
            bot.deactive();
        }
    }

    public void hitBomb() {
        PlayerBullet playerBullet = GameObject.findIntersects(PlayerBullet.class, this);
        if (playerBullet != null) {
            playerBullet.explode();
        }
    }

    public void hitBlock() {
        Platform block = GameObject.findIntersects(Platform.class, this);
        if (block != null) {
            if (block.isType == 1){
                block.deactive();

            }
        }
    }
}
