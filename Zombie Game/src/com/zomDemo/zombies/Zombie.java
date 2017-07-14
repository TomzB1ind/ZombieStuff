package com.zomDemo.zombies;

import com.zomDemo.Player;
import java.awt.*;

/**
 * Created by Faylo on 7/11/2017.
 */
public class Zombie {
    Rectangle bounds;
    int speed;
    public Zombie(Rectangle bounds){
        this.bounds = bounds;
        speed = 1;
    }

    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public void move(Player player){
        Rectangle pBounds = player.getBounds();
        act(player);
        if (inSight(pBounds)) {
            if (pBounds.x > bounds.x) {
                bounds.x += speed;
            }
            if (pBounds.x < bounds.x) {
                bounds.x -= speed;
            }
            if (pBounds.y > bounds.y) {
                bounds.y += speed;
            }
            if (pBounds.y < bounds.y) {
                bounds.y -= speed;
            }
        }
    }
    public boolean contains(Rectangle rect){
        return bounds.intersects(rect);
    }
    private void act(Player player){
        if (contains(player.getBounds())){
            player.hit();
        }
    }
    private boolean inSight(Rectangle pBounds){
        double distance = Math.sqrt(Math.pow((bounds.x - pBounds.x), 2) + Math.pow((bounds.y - pBounds.y), 2));
        if (distance < 100)
            return true;
        else
            return false;
    }
}