package game.player;

import game.GameObject;
import game.Scene.SceneGameover;
import game.Scene.SceneManager;
import game.renderer.Renderer;

public class PlayerExplosion extends GameObject {

    public PlayerExplosion(){
        renderer = new Renderer("assets/images/players/die/", true);
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new SceneGameover());
    }
}
