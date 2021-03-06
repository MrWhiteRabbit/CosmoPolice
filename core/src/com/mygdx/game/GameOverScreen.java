package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import static java.lang.Thread.*;

public class GameOverScreen implements Screen{

    final Cosmos game;
    OrthographicCamera camera;


    public GameOverScreen(final Cosmos gam) {
        game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);



    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Texture goScr = new Texture("GameOverScreen.jpg");

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(goScr, camera.position.x - camera.viewportWidth / 2, 0);
        //game.font.draw(game.batch, "Your SCORE: " + bahAgressor, 20, 780);

        try {
            sleep(1000);
        } catch (InterruptedException ie){}

        game.batch.end();

        if (Gdx.input.isTouched()){
            try {
                sleep(1000);
            } catch (InterruptedException ie){}

            game.setScreen(new GameScreen(game));
            dispose();
        }

    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
