package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class uf3final extends Game {
	Pelota pelota;
	Paddle paddle;
	ArrayList<Rectangulos> bloques = new ArrayList<>();
	AssetManager manager;
	SpriteBatch shape;
	Texture background;
	int puntuacion;
	GameController gameController;
	BitmapFont font;
	uf3final(GameController gameController){
		this.gameController=gameController;
	}
	public void create() {
		manager = new AssetManager();
		manager.load("bola.png", Texture.class);
		manager.load("rectanguloazul.png", Texture.class);
		manager.load("rectangulolila.png", Texture.class);
		manager.load("rectangulonegro.png", Texture.class);
		manager.load("rectanguloverde.png", Texture.class);
		manager.load("nave_down.png", Texture.class);
		manager.load("fondo-azul-oscuro.png", Texture.class);
		manager.finishLoading();
		paddle = new Paddle("nave_down.png",50, 15, 50, 5);
		pelota = new Pelota(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 20, 5, 5, paddle);
		shape= new SpriteBatch();
		background = manager.get("fondo-azul-oscuro.png", Texture.class);
		int blockWidth = 80;
		int blockHeight = 40;
		for(int y = Gdx.graphics.getHeight() / 2; y + blockHeight < Gdx.graphics.getHeight(); y += blockHeight + 5) {
			for(int x = 5; x + blockWidth < Gdx.graphics.getWidth(); x += blockWidth + 5) {
				int p =(int) (Math.random()*4);
				switch (p){
					case 0:
						bloques.add(new Rectangulos(x, y, blockWidth, blockHeight,"rectanguloazul.png"));
						break;
					case 1:
						bloques.add(new Rectangulos(x, y, blockWidth, blockHeight,"rectangulolila.png"));
						break;
					case 2:
						bloques.add(new Rectangulos(x, y, blockWidth, blockHeight,"rectangulonegro.png"));
						break;
					case 3:
						bloques.add(new Rectangulos(x, y, blockWidth, blockHeight,"rectanguloverde.png"));
						break;
				}
			}
		}
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		puntuacion = 0;
	}

	public void update() {
		pelota.update(Gdx.graphics.getDeltaTime());
		paddle.update();

		for(int x = 0; x< bloques.size(); x++) {
			if(bloques.get(x).checkBallColission(pelota.circle)) {
				pelota.cambiarY();
				puntuacion+=50;
				bloques.remove(x);
			}
			if(pelota.y<0){
				GameOverScreen game = new GameOverScreen(gameController,puntuacion);
				gameController.setScreen(game);
			}
			if(bloques.size()==0){
				WinScreen game = new WinScreen(gameController,puntuacion);
				gameController.setScreen(game);
			}
		}
	}


	public void render () {
			update();
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			shape.begin();
			shape.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			pelota.draw(shape);
			paddle.draw(shape);
			for (Rectangulos block: bloques) {
				block.draw(shape);
			}
			// Dibujamos la puntuación
			BitmapFont font = new BitmapFont();
			font.draw(shape, "Puntuación: " + puntuacion, 10, Gdx.graphics.getHeight() - 10);
			shape.end();
	}


}
