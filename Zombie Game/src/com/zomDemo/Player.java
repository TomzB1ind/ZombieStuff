package com.zomDemo;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Faylo on 7/11/2017.
 */
public class Player {
    Rectangle bounds;
    double vx , vy, accel;
    int maxspeed;
    public boolean alive;
    public Player(){
        bounds = new Rectangle(20, 20, 10, 10);
        alive = true;
        vx = 0;
        vy = 0;
        maxspeed = 5;
        accel = .5;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        if (alive){
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }

    public void move(ArrayList<String> dirs){
        if (dirs.contains("up")){
            vy -= accel;
        }
        if (dirs.contains("down")){
            vy += accel;
        }
        if (dirs.contains("right")){
            vx += accel;
        }
        if (dirs.contains("left")){
            vx -= accel;
        }
        if (vx > maxspeed){
            vx = maxspeed;
        }
        if (vx < -maxspeed){
            vx = -maxspeed;
        }
        if (vy > maxspeed){
            vy = maxspeed;
        }
        if (vy < -maxspeed){
            vy = -maxspeed;
        }
        if (alive){
            bounds.y += (int) vy;
            bounds.x += (int) vx;
        }
        vx *= .9;
        vy *= .9;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void hit(){
        alive = false;
    }
}