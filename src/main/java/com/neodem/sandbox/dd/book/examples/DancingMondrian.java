package com.neodem.sandbox.dd.book.examples;

import java.awt.Graphics;

import com.neodem.graphics.dd.engine.common.Color;
import com.neodem.graphics.dd.engine.applet.SpriteBasedAnimationShell;
import com.neodem.graphics.dd.engine.sprite.sprites.DancingRectangleSprite;
import com.neodem.graphics.dd.engine.sprite.sprites.Sprite;

public class DancingMondrian extends SpriteBasedAnimationShell {

	private static final long serialVersionUID = 1L;
	private static final int NUM_SPRITES = 9;
	private Sprite[] sprites;
	private static final int SCREENW = 300;
	private static final int SCREENH = 300;
	private static final int DEFAULT_REFRESHRATE = 20;
	private static final Color BGCOLOR = Color.black;

	public DancingMondrian() {
		super(DEFAULT_REFRESHRATE, SCREENW, SCREENH, BGCOLOR);
	}
	
	protected void initSprites() {
		sprites = new Sprite[NUM_SPRITES];

		sprites[0] = new DancingRectangleSprite(0, 0, 90, 90, Color.yellow);
		sprites[1] = new DancingRectangleSprite(250, 0, 40, 190, Color.yellow);
		sprites[2] = new DancingRectangleSprite(200, 55, 60, 135, Color.yellow);
		sprites[3] = new DancingRectangleSprite(80, 200, 220, 90, Color.blue);
		sprites[4] = new DancingRectangleSprite(100, 10, 90, 80, Color.blue);
		sprites[5] = new DancingRectangleSprite(80, 100, 110, 90, Color.lightGray);
		sprites[6] = new DancingRectangleSprite(200, 0, 45, 45, Color.red);
		sprites[7] = new DancingRectangleSprite(0, 100, 70, 200, Color.red);
		sprites[8] = new DancingRectangleSprite(200, 55, 60, 135, Color.magenta);
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
