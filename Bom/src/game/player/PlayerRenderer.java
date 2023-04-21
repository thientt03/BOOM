package game.player;

import game.GameObject;
import game.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerRenderer extends Renderer {
    Renderer leftRenderer;
    Renderer rightRenderer;
    Renderer upRenderer;
    Renderer downRenderer;
    Renderer currentRenderer;
    String[] path;
    public static int buff;
    public PlayerRenderer(){
        path = new String[4];
            path[0] = "C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Minion_Up";
            path[1] = "C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Minion_Down";
            path[2] = "C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Minion_Right";
            path[3] = "C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Minion_Left";
//sai đường dẫn path
            this.upRenderer = new Renderer(path[0]);
            this.downRenderer = new Renderer(path[1]);
            this.rightRenderer = new Renderer(path[2]);
            this.leftRenderer = new Renderer(path[3]);
            this.currentRenderer = this.downRenderer;
    }




    @Override
    public void render(Graphics g, GameObject master) {
        if(master.velocity.x > 0) {
            this.currentRenderer = this.rightRenderer;
        } else if(master.velocity.x < 0) {
            this.currentRenderer = this.leftRenderer;
        } else if(master.velocity.y > 0) {
            this.currentRenderer = this.downRenderer;
        } else if(master.velocity.y < 0){
            this.currentRenderer = this.upRenderer;
        }
        currentRenderer.render(g, master);
    }

}
