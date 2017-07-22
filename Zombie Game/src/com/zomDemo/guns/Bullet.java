package com.zomDemo.guns;

import com.zomDemo.zombies.Zombie;

import java.awt.*;

/**
 * Created by Faylo on 7/14/2017.
 */
public class Bullet {
    private Rectangle bounds;
    private int vx, vy;
    private int speed;
    public Bullet(Rectangle bounds, int speed, Point target){
        this.bounds = bounds;
        this.speed = speed;
        int dx = target.x-bounds.x;
        int dy = target.y-bounds.y;
        int totalChange = Math.abs(dx)+Math.abs(dy);
        vx = (dx*speed)/totalChange;
        vy = (dy*speed)/totalChange;
    }

    public void draw(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(bounds.x, bounds.y, 2, 2);
    }

    public void move(){
        bounds.x += vx;
        bounds.y += vy;
    }

    public boolean hit(Zombie zombie){
        Rectangle zbounds = zombie.getBounds();
        if (bounds.intersects(zbounds)){
            return true;
        } else {
            return false;
        }
    }
}
