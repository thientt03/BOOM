package game.player;

import game.GameObject;
import game.renderer.Renderer;

import java.awt.*;

public class PlayerRenderer2 extends Renderer {
    Renderer leftRenderer2;
    Renderer rightRenderer2;
    Renderer upRenderer2;
    Renderer downRenderer2;
    Renderer currentRenderer2;
    String[] pat;

        public PlayerRenderer2(){
        pat = new String[4];
            pat[0] = "C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\SuperMinion\\Super_Up";
            pat[1] = "C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\SuperMinion\\Super_Down";
            pat[2] = "C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\SuperMinion\\Super_Right";
            pat[3] = "C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\SuperMinion\\Super_Left";
//sai đường dẫn path
            this.upRenderer2 = new Renderer(pat[0]);
            this.downRenderer2 = new Renderer(pat[1]);
            this.rightRenderer2 = new Renderer(pat[2]);
            this.leftRenderer2 = new Renderer(pat[3]);
            this.currentRenderer2 = this.downRenderer2;
    }




    @Override
    public void render(Graphics g, GameObject master) {
        if(master.velocity.x > 0) {
            this.currentRenderer2 = this.rightRenderer2;
        } else if(master.velocity.x < 0) {
            this.currentRenderer2 = this.leftRenderer2;
        } else if(master.velocity.y > 0) {
            this.currentRenderer2 = this.downRenderer2;
        } else if(master.velocity.y < 0){
            this.currentRenderer2 = this.upRenderer2;
        }
        currentRenderer2.render(g, master);
    }

}
