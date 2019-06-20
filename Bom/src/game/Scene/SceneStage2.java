package game.Scene;

import game.GameObject;
import game.enemy.Bot1;
import game.enemy.Bot2;
import game.enemy.Bot3;
import game.map.Map;
import game.opition.Background;
import game.player.Player;
import game.player.item.ItemBullet;
import game.player.item.ItemPower;
import game.player.item.ItemSpeed;
import game.player.item.ItemSuper;

public class SceneStage2 extends Scene {
    public static int x =2;
    @Override
    public void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(ItemBullet.class);
        GameObject.recycle(ItemSpeed.class);
        GameObject.recycle(ItemPower.class);
        GameObject.recycle(ItemSuper.class);
        Map map = Map.load("assets/images/stage/Map2.json");
        map.generate();
        GameObject.recycle(Player.class);
        GameObject.recycle(Bot1.class);
        GameObject.recycle(Bot2.class);
        GameObject.recycle(Bot3.class);

    }
}
