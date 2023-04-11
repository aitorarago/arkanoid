package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Paddle {
    int x;
    int y;
    int width;
    int height;
    Texture texture;

    Rectangle rectangle;

    public Paddle(String texture,int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        this.texture = new Texture(texture);
    }

    public void handleInput() {
        x = Gdx.input.getX();
    }

    public void update() {
        handleInput();
        rectangle.setX(x);
        rectangle.setY(y);
    }

    public void draw(SpriteBatch shape) {
        shape.draw(texture, x, y, width, height);
    }
}
