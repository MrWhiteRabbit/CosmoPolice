package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Array;

import com.badlogic.gdx.math.Rectangle;
import java.util.Iterator;


public class GameScreen implements Screen {

	final Cosmos game;
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture ship1Image;
	Texture agrImage;
	Texture bG;
	Rectangle ship;
	Vector3 touchPos;
	Array<Rectangle> agrfalls;
	long lastFallTime;
	Sound bah;
	String rank;
	int bahAgressor;
	int nobahAgressor;
	int rankMath;
	int speedFall;


	public GameScreen(final Cosmos gam) {
		this.game = gam;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);

		touchPos = new Vector3();

		batch = new SpriteBatch();

		ship1Image = new Texture("ship.png");
		agrImage = new Texture("agr.png");
		bG = new Texture("bg.jpg");

		bah = Gdx.audio.newSound(Gdx.files.internal("bah.mp3"));


		ship = new Rectangle();
		ship.x = 480 / 2 - 64 / 2;
		ship.y = 20;
		ship.width = 64;
		ship.height = 64;

		agrfalls = new Array<Rectangle>();
		spawnAgrFall();


	}

	private void spawnAgrFall() {
		Rectangle agrFall = new Rectangle();
		agrFall.x = MathUtils.random(0, 480 - 64);
		agrFall.y = 800;
		agrFall.width = 64;
		agrFall.height = 64;
		agrfalls.add(agrFall);
		lastFallTime = TimeUtils.nanoTime();
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();

		game.batch.draw(bG, camera.position.x - camera.viewportWidth / 2, 0);
		game.batch.draw(ship1Image, ship.x, ship.y);

		game.font.draw(game.batch, "Kills: " + bahAgressor, 20, 780);
		game.font.draw(game.batch, "Attack: " + nobahAgressor, 20, 760);
		game.font.draw(game.batch, "Rank: " + rank, 20, 740);

		for (Rectangle agrFall : agrfalls) {
			game.batch.draw(agrImage, agrFall.x, agrFall.y);
		}

		game.batch.end();

		if (Gdx.input.isTouched()) {

			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			ship.x = (int) (touchPos.x - 64 / 2);
			ship.y = (int) (touchPos.y - 64 / 2);

		}

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) ship.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) ship.x += 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) ship.y -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) ship.y += 200 * Gdx.graphics.getDeltaTime();


		if (ship.x < 0) ship.x = 0;
		if (ship.x > 416) ship.x = 480 - 64;
		if (ship.y < 0) ship.y = 0;
		if (ship.y > 336) ship.y = 400 - 64;

		if (TimeUtils.nanoTime() - lastFallTime > 1000000000) spawnAgrFall();

		Iterator<Rectangle> iter = agrfalls.iterator();
		while (iter.hasNext()) {
			speedFall = MathUtils.random(0, 400);
			Rectangle agrFall = iter.next();
			agrFall.y -= speedFall * Gdx.graphics.getDeltaTime();
			if (agrFall.y + 64 < 0) {
				iter.remove();
				nobahAgressor++; //увеличиваем счетчик пропущенных

			}

			if (agrFall.overlaps(ship)) {
				bahAgressor++;//счетчик уничтоженных
				bah.play();

				rankMath = bahAgressor - nobahAgressor;

				if (rankMath < 5){
					rank = "Soldier";
				}
				if (rankMath >= 5 && rankMath < 10) {
					rank = "Sergeant";
				}
				if (rankMath >= 10 && rankMath < 20) {
					rank = "Lieutenant";
				}
				if (rankMath >= 20 && rankMath < 30) {
					rank = "Captain";
				}
				if (rankMath >= 30 && rankMath < 40) {
					rank = "Col.";
				}
				if (rankMath >= 40 && rankMath < 50) {
					rank = "General";
				}
				if (rankMath >= 50) {
					rank = "Admiral";
				}
				iter.remove();
			}
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

		agrImage.dispose();
		ship1Image.dispose();
		bah.dispose();
	}
}
