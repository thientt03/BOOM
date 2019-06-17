package game.Scene;
import game.GameObject;
import game.enemy.Bot1;
import game.enemy.Bot2;
import game.enemy.Bot3;
import game.map.Map;
import game.player.Player;
import game.player.item.ItemBullet;
import game.player.item.ItemPower;
import game.player.item.ItemSpeed;
import game.player.item.ItemSuper;

public class SceneStage1 extends Scene {
    @Override
    public void init() {
        Map map = Map.load("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\mapjson.json");
        map.generate();
        GameObject.recycle(Player.class);
        GameObject.recycle(Bot1.class);
        GameObject.recycle(Bot2.class);
        GameObject.recycle(Bot3.class);
        GameObject.recycle(ItemBullet.class);
        GameObject.recycle(ItemSpeed.class);
        GameObject.recycle(ItemPower.class);
        GameObject.recycle(ItemSuper.class);
    }
}
