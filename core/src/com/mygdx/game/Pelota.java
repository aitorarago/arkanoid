package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Pelota extends Actor{
    int x;
    int y;
    int radius;
    int xSpeed;
    int ySpeed;
    Circle circle;
    Paddle paddle;
    Texture ballTexture;
    float timeElapsed;

    public Pelota(int x, int y, int radius, int xSpeed, int ySpeed, Paddle paddle) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        circle = new Circle(x, y, radius);
        this.paddle = paddle;
        ballTexture= new Texture("bola.png");
        timeElapsed=0f;
    }

    public void update(float deltatime) {
        timeElapsed += deltatime;
        x += xSpeed;
        y += ySpeed;

        circle.setPosition(x, y);

        if(x < radius || x > (Gdx.graphics.getWidth() - radius)) {
            xSpeed = -xSpeed;
        }

        if(Intersector.overlaps(circle, paddle.rectangle) || y > (Gdx.graphics.getHeight() - radius)) {
            ySpeed = -ySpeed;
        }

        if (timeElapsed%10==0) {
            xSpeed *= 1.1;
            ySpeed *= 1.1;
        }
    }


    public void cambiarY() {
        ySpeed = -ySpeed;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(ballTexture, circle.x - circle.radius, circle.y - circle.radius,
                circle.radius * 2, circle.radius * 2);
    }

}