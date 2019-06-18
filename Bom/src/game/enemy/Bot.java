package game.enemy;

import game.GameObject;

import game.Scene.SceneGameover;
import game.Scene.SceneManager;
import game.enemy.ai.AI;

import game.map.Platform;
import game.opition.Settings;
import game.physics.BoxCollider;
import game.player.Player;

public class Bot extends GameObject {
    //necessary to correct move
    public final double MAX_STEPS;
    public final double rest;
    public double steps;
    public int speed = 1;
    public int _direction = -1;
    public static int damage;

    public AI ai;


    public Bot() {
        MAX_STEPS = (Settings.TILES_SIZE) / this.speed;
        //System.out.println(MAX_STEPS);
        this.rest = (MAX_STEPS - (int) MAX_STEPS) / MAX_STEPS;
        //System.out.println(rest);
        this.steps = MAX_STEPS;
        hitBox = new BoxCollider(this,38,38);
        damage = 1;

    }

    @Override
    public void run() {
        super.run();
        caculateMove();
//        limit();
        this.hitPlayer();
    }
    public void hitPlayer() {
        Player player = GameObject.findIntersects(Player.class,hitBox);
        if (player != null){
            player.takeDamage(damage);
        }
    }

    public void caculateMove() {
        int xa = 0, ya = 0;
        if(this.steps <= 0){
            _direction = ai.calculateDirection();
            this.steps = MAX_STEPS;
        }

        if(_direction == 0) ya--;
        if(_direction == 2) ya++;
        if(_direction == 3) xa--;
        if(_direction == 1) xa++;

        if(canMove(xa, ya)) {
            this.steps -= 1 + rest;
            this.position.add(xa * speed,ya * speed);
        } else {
            this.steps = 0;
        }
    }

    public boolean canMove(double x, double y) {
        Platform wall = GameObject.findIntersects(Platform.class, this.hitBox.shift(x,y));
        if (wall != null){
            return false;
        }
        return true;
    }

    private void limit() {
        if(position.x < 66) {
            position.set(66, position.y);
        }
        if(position.x > Settings.GAME_WIDTH - 66) {
            position.set(
                    Settings.GAME_WIDTH - 66,
                    position.y
            );
        }
        if(position.y < 110) {
            position.set(position.x, 110);
        }
        if(position.y > Settings.GAME_HEIGHT - 66) {
            position.set(
                    position.x,
                    Settings.GAME_HEIGHT - 66
            );
        }
    }


}
