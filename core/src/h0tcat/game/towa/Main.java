package h0tcat.game.towa;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import java.util.HashMap;

import h0tcat.game.towa.ui.Title;

public class Main extends Game {
	private static HashMap<String, Screen> scenes;

	@Override
	public void create () {
		scenes = new HashMap<>();
		
		scenes.put("title", new Title());
		setScreen(getScene("title"));
	}

	public static Screen getScene(String scene){
		return scenes.get(scene);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		for(String keys : scenes.keySet()){
			scenes.get(keys).dispose();
		}
	}
}