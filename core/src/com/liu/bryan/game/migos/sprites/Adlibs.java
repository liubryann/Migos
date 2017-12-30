package com.liu.bryan.game.migos.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by liubr_000 on 10/11/2017.
 */

public class Adlibs {
    private Vector2 position;
    private Texture adlib;
    private Rectangle bounds;

    public Adlibs(float x, float y, Texture texture) {

        position = new Vector2(x, y);
        adlib = texture;
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());


    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getAdlib() {
        return adlib;
    }
    public boolean collide(Rectangle player){
        return player.overlaps(bounds);
    }


}

