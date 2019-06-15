package game.player;

import game.physics.BoxCollider;
import game.renderer.Renderer;

public class Down extends DirectionExplosion {
    PlayerBullet explosion;

    public Down(){
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\explosions\\down", true);
        hitBox = new BoxCollider(this, 10,10);

    }

}
