package states;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.liu.bryan.game.migos.sprites.Wraithh;

import sun.rmi.runtime.Log;

import static com.badlogic.gdx.math.Interpolation.fade;

/**
 * Created by liubr_000 on 9/30/2017.
 */

public class LoadState extends State {
    private Texture bg;
    private Texture ground;
    private Wraithh wraith;
    private Sprite migos;
    TextureRegion migo;
    boolean hideMigos=false;
    private Stage fadeOut;
    float alpha = 1;
    private Image migoss;
    private Actor wraithh;
    private Music vroom;
    private Music highway85;


    protected LoadState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, MigosGame.WIDTH / 2, MigosGame.HEIGHT / 2);
        bg = new Texture("playBg.png");
        ground = new Texture("ground.png");
        wraith = new Wraithh(-50, 10);
       /* wraithh = new Actor();*/
        migos = new Sprite(new Texture("migos.png"));
        migos.setPosition(cam.position.x -(migos.getRegionWidth()/2)-10,20);
        migos.setSize(migos.getRegionWidth()*3/2, migos.getRegionHeight()*3/2);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        highway85 = Gdx.audio.newMusic(Gdx.files.internal("start.mp3"));
        highway85.setVolume(0.1f);
        highway85.play();

        vroom = Gdx.audio.newMusic(Gdx.files.internal("vroom.mp3"));
        vroom.setVolume(0.3f);
      /*  fadeOut = new Stage(new ScreenViewport(cam));
        migoss = new Image(new Texture("migos.png"));
        migoss.setPosition(cam.position.x -(migoss.getImageWidth()/2)-10,20);
        migoss.setSize(migoss.getImageWidth()*3/2, migoss.getImageHeight()*3/2);
        fadeOut.addActor(migoss);
        fadeOut.addActor(wraith);*/
        //????????????????


    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        stopCar();
        faded(dt);
       goAlittleFaster();


            //???????????????????????
        wraith.update(dt);
        cam.update();
if (wraith.getPosition().x> cam.viewportWidth){
    gsm.set(new PlayState(gsm));
}


    }

    public void faded(float dt){
        if (hideMigos==true){
            alpha = alpha-(0.9f)/(1f/dt);
            if(alpha <0){
               hideMigos=false;
                wraith.getVelocity().x = 200;
            }

        }

    }
    public void goAlittleFaster(){
        if (hideMigos=false)
        wraith.getVelocity().x = wraith.getVelocity().x*2f;
    }


    public void stopCar(){
        if (wraith.getPosition().x > cam.viewportWidth / 2 - wraith.getWIDTH() / 2) {
            /*wraith.getPosition().x = cam.viewportWidth / 2 - wraith.getWIDTH() / 2;*/
            wraith.getVelocity().x = 0;
            hideMigos=true;
            vroom.play();




        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,cam.position.x -(cam.viewportWidth/2), 35, cam.viewportWidth, cam.viewportHeight);
        sb.draw(ground, 0, -30, ground.getWidth()/2, ground.getHeight()/2);


        if (wraith.getVelocity().x!=0) {
            migos.draw(sb);
        }
        else{
            if(wraith.getVelocity().x ==0){
                migos.setAlpha(alpha);
                migos.draw(sb);


            }

        }

        sb.draw(wraith.getWraith(), wraith.getPosition().x, wraith.getPosition().y, wraith.getWIDTH(), wraith.getHEIGHT());
/*        fadeOut.draw();*/
        sb.end();

       /* if(hideMigos==true) {
            migos.setColor(1.0f, 1.0f, 1.0f, alpha);
            migos.draw(sb);
        }
*/
    }

    @Override
    public void dispose() {
        bg.dispose();
        migos.getTexture().dispose();
        wraith.getWraith().dispose();
        ground.dispose();
        highway85.dispose();

    }


}
