package game.map;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Platform extends GameObject {
    public int isType = 0;
    public Platform(){
        super();
        this.anchor.set(0,0);
        hitBox = new BoxCollider(this, 32, 32);
    }
    public static Platform create(int mapData) {
        Platform platform = new Platform();
        switch (mapData) {
            case 9:
                BufferedImage image9= SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\snow.png");
                platform.renderer = new Renderer(image9);
                platform.isType = 1;
                break;
            case 8:
                BufferedImage image8 = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\Stone.png");
                platform.renderer = new Renderer(image8);
                platform.isType = 1;
                break;
            case 7:
                BufferedImage image7 = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\signposts.png");
                platform.renderer = new Renderer(image7);
                platform.isType = 1;
                break;
            case 6:
                BufferedImage image6 = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\Sprite-0007.png");
                platform.renderer = new Renderer(image6);
                platform.isType = 1;
                break;
            case 5:
                BufferedImage image5 = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\Sprite-0005.png");
                platform.renderer = new Renderer(image5);
                platform.isType = 1;

                break;
            case 4:
                BufferedImage image4 = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\Sprite-0004.png");
                platform.renderer = new Renderer(image4);
                platform.isType = 1;
                break;
            case 3:
                BufferedImage image3 = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\Sprite-0003.png");
                platform.renderer = new Renderer(image3);
                platform.isType = 1;
                break;
            case 2:
                BufferedImage image2 = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\home.png");
                platform.renderer = new Renderer(image2);
                break;
            case 1:
                BufferedImage image1 = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Bom\\src\\game\\map\\Icebox.png");
                platform.renderer = new Renderer(image1);
                break;
        }

        return platform;
    }
    //lỗi trỏ vào path trên máy tính
}
