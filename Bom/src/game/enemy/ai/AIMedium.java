package game.enemy.ai;

import game.enemy.Bot;
import game.player.Player;

public class AIMedium extends AI {
    Player player;
    Bot bot;
    public AIMedium(Player player, Bot bot){
        this.player = player;
        this.bot = bot;
    }
    @Override
    public int calculateDirection() {
        if(this.player == null)
            return random.nextInt(4);

        int vertical = random.nextInt(2);

        if(vertical == 1) {
            int v = calculateRowDirection();
            if(v != -1)
                return v;
            else
                return calculateColDirection();

        } else {
            int h = calculateColDirection();

            if(h != -1)
                return h;
            else
                return calculateRowDirection();
        }
    }

    private int calculateColDirection() {
        if(this.player.position.x < this.bot.position.x)
            return 3;
        else if(this.player.position.x > this.bot.position.x)
            return 1;

        return -1;
    }

    private int calculateRowDirection() {
        if(this.player.position.y < this.bot.position.y)
            return 0;
        else if(this.player.position.y > this.bot.position.y)
            return 2;
        return -1;
    }
}
