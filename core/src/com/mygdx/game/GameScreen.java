package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    OrthographicCamera camera;
    uf3final game;
    public GameScreen(final uf3final gam) {
        this.game = gam;
// create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }
    @Override
    public void render(float delta) {
// clear the screen with a color
        ScreenUtils.clear(0.3f, 0.8f, 0.8f, 1);
// tell the camera to update its matrices.
        camera.update();
// tell the SpriteBatch to render in the
// coordinate system specified by the camera.
        game.shape.setProjectionMatrix(camera.combined);
// begin a new batch
        game.shape.begin();
        game.shape.draw(game.manager.get("fondo-azul-oscuro.png", Texture.class), 0,
                0);
        game.shape.end();
        game.render();
    }
    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void show() {
        game.create();
    }
    @Override
    public void hide() {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void dispose() {
    }
}
