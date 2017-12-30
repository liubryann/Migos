package states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by liubr_000 on 9/16/2017.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;
    protected State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();

    }
    protected abstract void handleInput();

    public abstract void update(float dt);
    //delta time is difference between one frame rendered and next

    public abstract void render(SpriteBatch sb);
    //spritebatch is container for everything we need to render

    public abstract void dispose();

}
