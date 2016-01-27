package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen{

    final Cosmos game;
    OrthographicCamera camera;


    public MainMenuScreen(final Cosmos gam) {
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
        Texture stScr = new Texture("StartScreen.jpg");

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(stScr, camera.position.x - camera.viewportWidth / 2, 0);


        game.batch.end();

        if (Gdx.input.isTouched()){
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
