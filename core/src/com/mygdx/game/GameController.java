package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class GameController extends Game {
    SpriteBatch batch;
    BitmapFont smallFont, bigFont,puntuacion;
    public void create() {
        batch = new SpriteBatch();
// Create bitmap fonts from TrueType font
        FreeTypeFontGenerator generator = new
                FreeTypeFontGenerator(Gdx.files.internal("fuente.otf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new
                FreeTypeFontGenerator.FreeTypeFontParameter();
        FreeTypeFontGenerator generator1 = new
                FreeTypeFontGenerator(Gdx.files.internal("8bitOperatorPlus-Bold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params1 = new
                FreeTypeFontGenerator.FreeTypeFontParameter();
        params.size = 22;
        params.borderWidth = 2;
        params.borderColor = Color.BLACK;
        params.color = Color.WHITE;
        smallFont = generator.generateFont(params); // font size 22 pixels
        params.size = 50;
        bigFont = generator.generateFont(params); // font size 50 pixels
        params1.size = 25;
        puntuacion = generator1.generateFont(params1);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
        this.setScreen(new MainMenuScreen(this));
    }
    @Override
    public void render() {
        super.render(); // important!
    }
    public void dispose() {
    }

}
