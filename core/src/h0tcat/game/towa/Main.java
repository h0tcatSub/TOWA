package h0tcat.game.towa;

import com.badlogic.gdx.Game;

import h0tcat.game.towa.ui.Title;

public class Main extends Game {

	@Override
	public void create () {
		setScreen(new Title(this));
	}

	@Override
	public void render () {
		super.render();
	}
}