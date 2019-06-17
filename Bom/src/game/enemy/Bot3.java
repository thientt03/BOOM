package game.enemy;

import game.enemy.ai.AILow;
import game.physics.BoxCollider;
import game.renderer.Renderer;

public class Bot3 extends Bot{
    public Bot3(){
        this.renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\enemy");
        this.hitBox = new BoxCollider(this,31,31);
        this.position.set(550,415);
        ai = new AILow();
    }
}
