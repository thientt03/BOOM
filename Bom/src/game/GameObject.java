package game;

import game.Scene.BackgroundGameover;
import game.physics.BoxCollider;
import game.renderer.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import game.opition.Vector2D;

public class GameObject {//player, background, playerBullet
    //quản lí đối tượng(static)
    public static ArrayList<GameObject> objects = new ArrayList<>();


    public static void clearAll(){
        objects.clear();
    }
    public static <E extends GameObject> E find(Class<E> cls) {
        // luot qua mang objects
        // kiem tra tung phan tu
        // neu phan tu thoa man >> return
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.getClass().isAssignableFrom(cls)
                    && object.active) {
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersects(Class <E> cls, BoxCollider hitBox){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            //1.active
            //2.object ~ cls
            //3.object.hitBpx != null && object.hitBox.intersects(hitBox)
            if (object.active && cls.isAssignableFrom(object.getClass()) && object.hitBox != null && object.hitBox.intersects(hitBox)){
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersects(Class <E> cls, GameObject source){
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.getClass().isAssignableFrom(cls)
                    && object.active
                    && object.intersects(source)){
                return (E) object;
            }
        }
        return null;
    }



    public static <E extends GameObject> E recycle(Class<E> cls){
        E result = null;
        // Tìm kiếm phần tử bị deactive > reset > return
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (!object.active
                    && object.getClass().isAssignableFrom(cls)){
                result =(E) object;
                break;
            }
        }
        if (result != null){
            result.reset();
            return result;
        }

        // nếu không tìm thấy > reset > return
        try {
            result = cls.getConstructor().newInstance();
            return result;
        } catch (Exception ex){
            return null;
        }

    }

    public static <E extends GameObject> E  findInactive(Class<E> cls){//Player.class || Background.class
        for (int i =0; i< objects.size(); i++){
            GameObject object = objects.get(i);
            //cls truyền vào
            //objectactive == false
            if (cls.isAssignableFrom(object.getClass())&& !object.active){
                return (E)object;
            }
        }

        return null;
    }
    //định nghĩa đối tượng

    //Renderer renderer
    public Renderer renderer;
    public Vector2D position;
    public boolean active;
    public Vector2D velocity;
    public BoxCollider hitBox; // = null lafk va cham
    public Vector2D anchor;

    public GameObject(){
        objects.add(this);
        position = new Vector2D();//vị trí mặc định (0,0)
        active = true;
        velocity = new Vector2D();
        anchor = new Vector2D(0.5,0.5);
    }

    //hàm vẽ ảnh
    public void render(Graphics g){
        if (hitBox != null) {
            hitBox.render(g);
        }
        if (renderer != null){
            renderer.render(g, this);
        }
    }

    //hàm xử lí logic
    public void run(){
        position.add(velocity.x, velocity.y);
    }

    public void deactive(){
        active = false;
    }

    public void reset(){
        active = true;
    }

    public boolean intersects(GameObject other){
        if(this.hitBox != null && other.hitBox !=null){
            return this.hitBox.intersects(other.hitBox);
        }
        return false;
    }

}
