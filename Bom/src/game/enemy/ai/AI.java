package game.enemy.ai;

import java.util.Random;

public  abstract class AI {
    public Random random =new Random();
    public abstract int calculateDirection();
}
