package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.liu.bryan.game.migos.sprites.Adlibs;
import com.liu.bryan.game.migos.sprites.Twelve;
import com.liu.bryan.game.migos.sprites.Wraithh;

import java.sql.Time;

import sun.rmi.runtime.Log;

import static com.badlogic.gdx.Gdx.audio;
import static com.badlogic.gdx.Input.Keys.M;


/**
 * Created by liubr_000 on 9/16/2017.
 */

public class PlayState extends State {
    private Twelve wraith;
    private static final int GROUND_Y_OFFSET = -30;
    private Texture bg;

    private Adlibs huh;
    private Adlibs north;
    private Adlibs moms;
    private Adlibs stank;
    private Adlibs woo;
    private Adlibs fuck;
    private Adlibs migo;
    private Adlibs adlib;
    private Adlibs adlib2;

    private float time=0f;
    private Music reloop;

    Sprite ground;
    private Vector2 groundPos1, groundPos2;





    public PlayState(GameStateManager gsm) {
        super(gsm);
        /*highway85 = Gdx.audio.newMusic(Gdx.files.internal("highway85.mp3"));
        highway85.setLooping(true);
        highway85.setVolume(0.1f);
        highway85.play();*/
        wraith =new Twelve(-700, 10);
        cam.setToOrtho(false, MigosGame.WIDTH/2, MigosGame.HEIGHT/2);
        bg = new Texture("playBg.png");

        ground = new Sprite(new Texture("ground.png"));
        groundPos1 = new Vector2(cam.position.x-cam.viewportWidth/2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((cam.position.x-cam.viewportWidth/2) + ground.getWidth()/2, GROUND_Y_OFFSET);



        reloop = audio.newMusic(Gdx.files.internal("iDied.mp3"));
        reloop.play();
        reloop.setVolume(0.1f);
        /*adlibsArray = new Array<Adlibs>();*/

    }


    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            wraith.jump();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        updateGround();
        wraith.update(dt);
        delayFollow();

        cam.update();
        /*Gdx.app.debug("cam", ""+cam.position.x);*/
        time += dt;
        /*Gdx.app.debug("startTime", ""+time);*/
        createAdlib(5, 5.1f, new Texture("Huhh.png"));
        createAdlib(12.8f, 12.9f, new Texture("North.png"));
        createAdlib(15.7f, 15.8f, new Texture("Moms.png"));
        createAdlib(18.6f, 18.7f, new Texture("Stank.png"));
        createAdlib(21.5f, 21.6f, new Texture("Woo.png"));
        createAdlib(23.9f, 24f, new Texture("Fuckk.png"));
        createAdlib(30f, 30.1f, new Texture("Migo.png"));
        createAdlib(33, 33.1f, new Texture("Qhuh.png"));
        createAdlib(36, 36.1f, new Texture("Qhuh.png"));
        createAdlib(38.5f, 38.6f, new Texture("What.png"));
        createAdlib2(39f, 39.1f, new Texture("Bow.png"));
        createAdlib(40.5f,40.6f, new Texture("Uh.png"));
        createAdlib2(41.4f, 41.5f, new Texture("Uh.png"));

        /*if (time > 5 && time < 5.1) {
            huh = new Adlibs(cam.position.x + 280, 10, new Texture("Huhh.png"));
        }
        if (time > 12.8 && time < 12.9) {
            north = new Adlibs(cam.position.x + 280, 10, new Texture("North.png"));

        }
        if (time > 15.7 && time < 15.8) {
            moms = new Adlibs(cam.position.x + 280, 10, new Texture("Moms.png"));
        }
        if(time>18.6&&time<18.7){
            stank = new Adlibs(cam.position.x + 280, 15, new Texture("Stankkk.png"));

        }
        if(time>21.5&&time<21.6){
            woo = new Adlibs(cam.position.x+280, 10, new Texture("Woo.png"));
        }
        if(time>23.9&&time<24){
            fuck = new Adlibs(cam.position.x+280, 15, new Texture("Fuckk.png"));
        }
        if(time>30&&time<30.1){
            migo = new Adlibs(cam.position.x+280, 10, new Texture("Migo.png"));
        }*/
        /*if (time > 33 && time < 33.1) {
            huh = new Adlibs(cam.position.x + 280, 10, new Texture("Qhuh.png"));
        }*/
       /* if (time > 36 && time < 36.1) {
            huh = new Adlibs(cam.position.x + 280, 10, new Texture("Qhuh.png"));
        }*/

    }

    public void createAdlib(float time1, float time2, Texture texture){
        if(time>time1&&time<time2) {
                adlib = new Adlibs(cam.position.x + 280, 10, texture);
            }
        }
    public void createAdlib2(float time1, float time2, Texture texture){
        if(time>time1&&time<time2) {
            adlib2 = new Adlibs(cam.position.x + 280, 10, texture);
        }
    }


   //a possible idea I would like to come back to


    public void delayFollow(){
        if(wraith.getPosition().x > 50){
            cam.position.x = wraith.getPosition().x+150;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x -(cam.viewportWidth/2), 35, cam.viewportWidth, cam.viewportHeight);
        sb.draw(ground, groundPos1.x, groundPos1.y, ground.getWidth()/2, ground.getHeight()/2);
        sb.draw(ground, groundPos2.x, groundPos2.y, ground.getWidth()/2, ground.getHeight()/2);
        sb.draw(wraith.getWraithpic(), wraith.getPosition().x, wraith.getPosition().y, wraith.getWIDTH(), wraith.getHEIGHT());
        renderAdlibs(5, sb);
        renderAdlibs(12.9f, sb);
        renderAdlibs(16f,sb);
        renderAdlibs(18.9f,sb);
        renderAdlibs(21.8f, sb);
        renderAdlibs(24.1f,sb);
        renderAdlibs(30.1f,sb);
        renderAdlibs(33.1f,sb);
        renderAdlibs(36.1f, sb);
        renderAdlibs(39.1f,sb);
        renderSpecialAdlibs(39.1f, adlib2, sb);
        renderAdlibs(41.1f,sb);
        renderSpecialAdlibs(42.1f, adlib2, sb);

       /* if(time>22){
            sb.draw(stank.getAdlib(), stank.getPosition().x, stank.getPosition().y);
            checkCollision(stank);
            disposeAdlib(stank);
        }*/
        /*if (time>16){
            sb.draw(adlibsArray.get(0).getAdlib(), adlibsArray.get(0).getPosition().x, adlibsArray.get(0).getPosition().y);
        }*/

        sb.end();

    }
    public void renderSpecialAdlibs(float time1,Adlibs adlib, SpriteBatch batch){
        if(time> time1){
            batch.draw(adlib.getAdlib(), adlib.getPosition().x, adlib.getPosition().y);
            checkCollision(adlib);
            disposeAdlib(adlib);
        }
    }

    public void renderAdlibs(float time1, SpriteBatch batch){
        if(time> time1){
            batch.draw(adlib.getAdlib(), adlib.getPosition().x, adlib.getPosition().y);
            checkCollision(adlib);
            disposeAdlib(adlib);
        }
    }
    public void checkCollision(Adlibs adlib){
        if(adlib.collide(wraith.getBounds())){
            reloop.stop();
            reloop.dispose();
            gsm.set(new PlayState(gsm));

        }
    }

    public void disposeAdlib(Adlibs adlib){
        if(adlib.getPosition().x<cam.position.x-cam.position.x){
            adlib.getAdlib().dispose();
        }
    }
    @Override
    public void dispose() {
        bg.dispose();
        ground.getTexture().dispose();
        wraith.getWraithpic().dispose();
        reloop.dispose();
        adlib.getAdlib().dispose();
        adlib2.getAdlib().dispose();

    }
    private void updateGround(){
        //don't understand math behind this yet
        if(cam.position.x - (cam.viewportWidth/2) > groundPos1.x +ground.getWidth()/2)
            groundPos1.add(ground.getWidth(), 0);

        if(cam.position.x - (cam.viewportWidth/2) > groundPos2.x +ground.getWidth()/2)
            groundPos2.add(ground.getWidth(), 0);
        //i need to create the car or whatever to make the ground start to move
    }

}
