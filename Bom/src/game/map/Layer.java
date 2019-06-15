package game.map;

import java.util.List;
import game.opition.Vector2D;

public class Layer {
    private List<Integer> data;
    private int width;
    private int height;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public void generate() {
        for (int titleY = 0; titleY< height; titleY++){
            for (int titleX = 0; titleX< width; titleX++){
                int mapData = data.get(titleY*width + titleX);
                if (mapData != 0 ){
                    Platform platform = Platform.create(mapData);
                    platform.position.set(titleX*32, titleY*32);
                }
            }
        }
    }
}