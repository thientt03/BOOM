package game.Scene;

import game.GameObject;

public class SceneGameover extends game.Scene.Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundGameover.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
