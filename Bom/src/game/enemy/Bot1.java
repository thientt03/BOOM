package game.enemy;

import game.GameObject;
import game.enemy.ai.AIMedium;
import game.map.Platform;
import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.Renderer;

public class Bot1 extends Bot {
    public Bot1(){
        this.renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\enemy");
        this.hitBox = new BoxCollider(this,31,31);
        this.position.set(48,640-48);
        ai = new AIMedium(GameObject.find(Player.class), this);

    }
    public boolean canMove(double x, double y) {
        Platform block = GameObject.findIntersects(Platform.class, this.hitBox.shift(x,y));
        if (block != null){
            if (block.isType != 1){
                return false;

            }
        }
        return true;
    }
}
