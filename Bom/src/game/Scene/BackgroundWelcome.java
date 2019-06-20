//package game.Scene;
//
//import game.GameObject;
//import game.opition.GameWindow;
//import game.opition.Settings;
//import game.renderer.Renderer;
//import tklibs.SpriteUtils;
//
//import java.awt.image.BufferedImage;
//
//
//public class BackgroundWelcome extends GameObject {
//    public BackgroundWelcome(){
//        BufferedImage image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\images\\Map\\Background.png");
//        this.renderer = new Renderer(image);
//        this.position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
//    }
//
//    @Override
//    public void run(){
//        if(GameWindow.isAnyKeyPress){
//            super.run();
//            SceneManager.signNewScene(new SceneStage1());
//        }
//    }
//
//}
package game.Scene;

import game.GameObject;
import game.opition.GameWindow;
import game.opition.Settings;
import game.opition.Vector2D;
import game.renderer.Renderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;


public class BackgroundWelcome extends GameObject {
    Renderer background1;
    Renderer background2;
    Renderer background3;
    Renderer backgroundHD;
    Renderer backgroundHD2;
    Clip audio;
    public BackgroundWelcome(){
        background1 = new Renderer(SpriteUtils.loadImage("assets/images/backgpund/Background.png"));
        background2 = new Renderer(SpriteUtils.loadImage("assets/images/backgpund/Bat dau 1.png"));
        //background3 = new Renderer(SpriteUtils.loadImage("assets/images/cach choi 1.png"));
        backgroundHD = new Renderer(SpriteUtils.loadImage("assets/images/backgpund/hd2.png"));
        //backgroundHD2 = new Renderer(SpriteUtils.loadImage("assets/images/hd3.png"));
        this.renderer = background1;
        this.position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
        audio = AudioUtils.getSound("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\audio\\soundMenu.wav");
        AudioUtils.reply(audio);
        AudioUtils.loopForever(audio);
    }

    int x=0;
    @Override
    public void run(){
        super.run();
        //this.sayHello();
        if(isMouseOnButton1())
        {
            this.renderer = background2;
            if(GameWindow.mouseClicked ){
                Vector2D toMouse = Settings.mousePosition.clone();
                System.out.println("Hello");
                AudioUtils.pause(audio);
                SceneManager.signNewScene(new SceneStage2());
                GameWindow.mouseClicked = false;


            }

        }else if (isMouseOnButton2()){
            this.renderer = backgroundHD;
            GameWindow.mouseClicked = false;
        }
        else {
            GameWindow.mouseClicked = false;
            this.renderer = background1;
        }

    }


    private boolean isMouseOnButton2() {
        double x = Settings.mousePosition.x;
        double y = Settings.mousePosition.y;
        return x > 386 && x < 662 && y > 430 && y < 488;
    }

    private boolean isMouseOnButton1() {
        double x = Settings.mousePosition.x;
        double y = Settings.mousePosition.y;
        return x > 386 && x < 662 && y > 337 && y < 395;
    }
    private void sayHello() {
        Vector2D toMouse = Settings.mousePosition.clone();
//        toMouse.substract(this.position.x, this.position.y);
        //System.out.println(Settings.mousePosition);
//        if(toMouse.getLength() < 3) {
//            // mouse is too close >> player idle
//            this.velocity.set(0, 0);
//        } else {
//            // else player move to mouse position
////            this.velocity.set(0, 0.5);
////            this.velocity.setAngle(toMouse.getAngle());
//            this.velocity.set(toMouse.x, toMouse.y);
//            this.velocity.setLength(3);
//        }
        if(GameWindow.mouseClicked) {
            System.out.println("Hello");
            GameWindow.mouseClicked = false;
        }
    }

}
