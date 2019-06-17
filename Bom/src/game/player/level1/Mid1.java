package game.player.level1;

import game.physics.BoxCollider;
import game.player.DirectionExplosion;
import game.renderer.Renderer;

public class Mid1 extends DirectionExplosion {
    public  Mid1(){
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\explosions\\level1\\Mid", true);
        hitBox = new BoxCollider(this, 10,10);
    }


}
