package game.opition;

import game.GameObject;
import game.Scene.SceneGamewelcome;
import game.Scene.SceneManager;
import game.enemy.EnemySummoner;
import game.map.Map;
import game.player.Player;
import game.player.item.ItemSummoner;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public static Player player;
    public static Background background;
    public static EnemySummoner enemySummoner;

    public GamePanel(){
//        Map map = Map.load("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\mapjson.json");
//        map.generate();
//        this.background = new Background();
//        this.player = new Player();
//        EnemySummoner es = new EnemySummoner();
//        ItemSummoner itemSummoner = new ItemSummoner();
        SceneManager.signNewScene(new SceneGamewelcome());
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0,0, 800, 800);
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }
    private void renderAll() {
        repaint(); // goi lai ham paint()
    }

    public void GameLoop(){
        long lastTime = 0;
        while (true){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000/60){
                //run logic
                this.runAll();
                this.renderAll();
                //render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }

    public void runAll(){
        for (int i =0; i < GameObject.objects.size(); i++){
            GameObject object = GameObject.objects.get(i);
            if (object.active){
                object.run();
            }
        }
    }
}
