package game.Scene;

import game.GameObject;

public class SceneBackgroundWin extends game.Scene.Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundWin.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
