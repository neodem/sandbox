package com.neodem.sandbox.dd.book.examples;

import java.awt.Graphics;

import com.neodem.graphics.dd.engine.common.Color;
import com.neodem.graphics.dd.engine.applet.SpriteBasedAnimationShell;
import com.neodem.graphics.dd.engine.sprite.Moveable;
import com.neodem.graphics.dd.engine.sprite.sprites.BouncingRectange;
import com.neodem.graphics.dd.engine.sprite.sprites.RectangleSprite;
import com.neodem.graphics.dd.engine.sprite.sprites.Sprite;
import com.neodem.graphics.dd.engine.sprite.sprites.Sprite2D;

public class Bounce extends SpriteBasedAnimationShell {

	
	private static final int SCREENH = 300;
	private static final int SCREENW = 300;
	private static final long serialVersionUID = 1L;
	private static final int NUM_SPRITES = 3;
	private Sprite[] sprites;
	private static final int DEFAULT_REFRESHRATE = 80;
	private static final Color BGCOLOR = Color.black;

	public Bounce() {
		super(DEFAULT_REFRESHRATE, SCREENW, SCREENH, BGCOLOR);
	}

	protected void initSprites() {
		sprites = new Sprite[NUM_SPRITES];

		sprites[0] = new RectangleSprite(0, 0, SCREENW-1, SCREENH-1, Color.green);
		sprites[1] = new BouncingRectange(0, 0, 30, 30, Color.yellow, SCREENW-1, SCREENH-1);
		sprites[2] = new BouncingRectange(17, 17, 13, 13, Color.red, SCREENW-1, SCREENH-1);
		
		((Moveable)sprites[1]).setVelocity(4,3);
		((Moveable)sprites[2]).setVelocity(1,2);	
		((Sprite2D)sprites[2]).setFill(true);
	}

	protected void updateSprites() {
		for (int i = 0; i < NUM_SPRITES; i++) {
			sprites[i].update();
		}
	}

	protected void paintSprites(Graphics g) {
		for (int i = 0; i < NUM_SPRITES; i++) {
			sprites[i].paint(g);
		}
	}



}
