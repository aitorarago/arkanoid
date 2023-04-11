package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Rectangulos extends Actor{
    int x, y, width, height;
    Rectangle rectangle;
    String filepath;
    Texture texture;

    public Rectangulos(int x, int y, int width, int height,String filename) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(x, y, width, height);
        this.filepath = filename;
        this.texture = new Texture(Gdx.files.internal(filepath));
    }

    public boolean checkBallColission(Circle circle) {
        return Intersector.overlaps(circle, rectangle);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

}
