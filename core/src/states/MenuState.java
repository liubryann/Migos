package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import static com.badlogic.gdx.Input.Keys.M;

/**
 * Created by liubr_000 on 9/17/2017.
 */

public class MenuState extends State {
    private Texture bg;
    private Texture migos;
    private Texture ground;
   /* private Stage playStage;
    private Texture playTexture;
    private TextureRegion playTxtRgn;
    private TextureRegionDrawable playDrawable;
    private ImageButton playBtn;
    private ScreenViewport screen;*/



    public MenuState(final GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, MigosGame.WIDTH/2, MigosGame.HEIGHT/2);
        bg = new Texture("atlport.png");
        migos = new Texture("migos.png");
        ground = new Texture("ground.png");

    /*    playStage=new Stage(new ScreenViewport());

        playTexture = new Texture(Gdx.files.internal("blueSurvive.png"));
        playTxtRgn = new TextureRegion(playTexture);
        playDrawable = new TextureRegionDrawable(playTxtRgn);
        playBtn = new ImageButton(playDrawable);
        playBtn.setPosition(cam.viewportWidth/2-(playBtn.getWidth()/2), cam.viewportHeight/2);
        playBtn.addListener(new ChangeListener() {
                                @Override
                                public void changed(ChangeEvent event, Actor actor) {
                                    gsm.set(new PlayState(gsm));
                                }
                            });
        playStage.addActor(playBtn);
        Gdx.input.setInputProcessor(playStage);
        */


    }


    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new LoadState(gsm));
            dispose();
        }
    }


    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0, 35, cam.viewportWidth, cam.viewportHeight);
        sb.draw(ground, 0,-30, ground.getWidth()/2, ground.getHeight()/2 );
        sb.draw(migos, cam.position.x -(migos.getWidth()/2)-10,20, migos.getWidth()*3/2, migos.getHeight()*3/2);

        sb.end();
        /*playStage.act();
        playStage.draw();*/
    }

    @Override
    public void dispose() {
        bg.dispose();
        migos.dispose();
        ground.dispose();
    }
}


