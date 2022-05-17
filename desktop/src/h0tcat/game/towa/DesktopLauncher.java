package h0tcat.game.towa;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setIdleFPS(60);
		config.setTitle("TOWA");
		config.setWindowedMode(840, 680);
		config.setResizable(false);
		new Lwjgl3Application(new Main(), config);
	}
}
