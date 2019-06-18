package game.player.level1;

import game.physics.BoxCollider;
import game.player.DirectionExplosion;
import game.renderer.Renderer;

public class Right1 extends DirectionExplosion {
    public Right1(){
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\explosions\\level1\\Right", true);
        hitBox = new BoxCollider(this, 80,10);

    }

}
