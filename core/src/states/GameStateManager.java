package states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by liubr_000 on 9/16/2017.
 */

public class GameStateManager {
    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
        //push item to top of stack
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
