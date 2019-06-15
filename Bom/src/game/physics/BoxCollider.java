package game.physics;

import game.GameObject;
import game.opition.Vector2D;

import java.awt.*;

public class BoxCollider {
    public int width;
    public int height;
    public Vector2D position;
    public Vector2D anchor;

    public BoxCollider(GameObject master, int width, int height){
        this.position = master.position;
        this.width = width;
        this.height = height;
        this.anchor = master.anchor;
    }

    public BoxCollider(Vector2D position, Vector2D anchor, int width, int height) {
        this.position = position;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public double top(){
        return this.position.y - this.anchor.y * this.height;
    }

    public double bot(){
        return this.top() + this.height;
    }

    public double left(){
        return this.position.x - this.anchor.x * this.width;
    }

    public double right(){
        return this.left() + this.width;
    }

    public boolean intersects(BoxCollider other){
        // this có giao với box truyền vào hay không (other)
        return other.bot() >= this.top()
                && other.top() <= this.bot()
                && other.right() >= this.left()
                && other.left() <= this.right();

    }

    public BoxCollider shift(double a, double b){
        Vector2D position = this.position.clone();
        position.add(a,b);
        return new BoxCollider(position, this.anchor, this.width, this.height);
    }

    public void render(Graphics g) {
        g.drawRect((int)left(),(int)top(),width,height);
    }
}
