package game.player.item;

import game.GameObject;
import game.opition.Settings;
import game.physics.BoxCollider;
import game.player.Player;

public class Item extends GameObject {
    public Item(){
        hitBox = new BoxCollider(this,32,32);
    }

    @Override
    public void run() {
        super.run();
        deactiveIfNeeded();
    }
    private void deactiveIfNeeded() {
        if (this.position.y > Settings.GAME_HEIGHT+30);
    }
    public void powerUp(Player player){
    }

}
