package com.liu.bryan.game.migos.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import static com.badlogic.gdx.Input.Keys.M;

/**
 * Created by liubr_000 on 9/30/2017.
 */

public class Wraithh {
    private Texture wraith;
    private Vector2 position;
    private Vector3 velocity;
    private int MOVEMENT = 120;
    private int WIDTH;
    private int HEIGHT;


    public Wraithh(int x, int y){
        position= new Vector2(x, y);
        velocity = new Vector3(MOVEMENT, 0, 0);
        wraith = new Texture("WRAITHFR.png");
        WIDTH = wraith.getWidth()/5;
        HEIGHT = wraith.getHeight()/5;
    }

    public void update(float dt){
        position.add(velocity.x*dt, 0);

    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public Texture getWraith() {
        return wraith;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
