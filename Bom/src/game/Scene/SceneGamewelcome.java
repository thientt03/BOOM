package game.Scene;

import game.GameObject;
import game.opition.Background;

public class SceneGamewelcome extends  Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundWelcome.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
