package com.liu.bryan.game.migos.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by liubr_000 on 9/28/2017.
 */

public class Twelve {
    private Texture wraithpic;
    private static final int MOVEMENT =220;
    private static final int GRAVITY = -20;
    private Vector3 position;
    private Vector3 velocity;
    private int WIDTH;
    private int HEIGHT;
    private Rectangle bounds;

    public Twelve(int x, int y ){
        wraithpic = new Texture("WRAITHFR.png");

        position = new Vector3(x, y, 0);
        velocity= new Vector3(0,0,0);
        WIDTH = wraithpic.getWidth()/5;
        HEIGHT = wraithpic.getHeight()/5;
        bounds = new Rectangle(x, y, WIDTH, HEIGHT);

    }
    public void jump(){
        velocity.y = 500;
    }

    public void update(float dt){
        position.add(MOVEMENT*dt, 0, 0);
        if(position.y>0)
            //only applies gravity if y position is greater than 0
            velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        //scale gravity to change in time(so it doesn't look like it happens instantly
        //multiples everything by the delta time
        position.add(MOVEMENT*dt, velocity.y, 0);
        //MOVEMENT * dt = moves forward in relation to change in delta time

        if (position.y<10){
            position.y=10;
            //sets y position to 0 if he falls below the screen
        }

        velocity.scl(1/dt);
        //1/dt reverses what you did there^^so you can do it again next frame

        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getWraithpic() {
        return wraithpic;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
