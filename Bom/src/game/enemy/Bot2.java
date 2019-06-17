package game.enemy;

import game.GameObject;
import game.enemy.ai.AIMedium;
import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.Renderer;

public class Bot2 extends Bot {
    public Bot2(){
        this.renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\enemy");
        this.hitBox = new BoxCollider(this,31,31);
        this.position.set(800-48,48);
        ai = new AIMedium(GameObject.find(Player.class), this);
    }

}
