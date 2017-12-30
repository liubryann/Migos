package com.liu.bryan.game.migos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import states.MigosGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=MigosGame.WIDTH;
		config.height=MigosGame.HEIGHT;
		config.title=MigosGame.TITLE;
		new LwjglApplication(new MigosGame(), config);
	}
}
