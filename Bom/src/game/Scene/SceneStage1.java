package game.Scene;

import game.enemy.EnemySummoner;
import game.map.Map;
import game.opition.Background;
import game.opition.GamePanel;
import game.player.Player;
import game.player.item.ItemSummoner;

public class SceneStage1 extends Scene {
    @Override
    public void init() {
        Map map = Map.load("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\mapjson.json");
        map.generate();
        GamePanel.background = new Background();
        GamePanel.player = new Player();
        EnemySummoner es = new EnemySummoner();
        ItemSummoner itemSummoner = new ItemSummoner();
    }
}
