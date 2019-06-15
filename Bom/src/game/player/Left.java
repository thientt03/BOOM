package game.player;

import game.physics.BoxCollider;
import game.renderer.Renderer;

public class Left extends DirectionExplosion {

    public Left(){
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\explosions\\left", true);
        hitBox = new BoxCollider(this, 10,10);

    }
}
