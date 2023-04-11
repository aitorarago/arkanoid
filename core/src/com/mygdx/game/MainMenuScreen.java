package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenuScreen implements Screen {
        private final GameController game;

        OrthographicCamera camera;
        public MainMenuScreen(final GameController gam) {
            game = gam;
            camera = new OrthographicCamera();
            camera.setToOrtho(false, 800, 480);
        }
        @Override
        public void render(float delta) {
            ScreenUtils.clear(0, 0, 1, 1);
            camera.update();
            game.batch.setProjectionMatrix(camera.combined);
            game.batch.begin();
            game.bigFont.draw(game.batch, "Welcome to Arkanoid", 250, 300);
                    game.bigFont.draw(game.batch, "Tap anywhere to begin!",
                            20, 180);
                    game.bigFont.draw(game.batch, "By Aitor",
                            50, 100);
            game.batch.end();
            if (Gdx.input.justTouched()) {
                uf3final uf3final = new uf3final(game);
                game.setScreen(new GameScreen(uf3final));
                dispose();
            }
        }
        @Override
        public void resize(int width, int height) {
        }
        @Override
        public void show() {
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