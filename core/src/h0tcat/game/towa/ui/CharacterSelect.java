package h0tcat.game.towa.ui;


import static com.badlogic.gdx.Gdx.graphics;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import h0tcat.game.towa.ui.util.Cursor;
import h0tcat.game.towa.util.GameFont;

public class CharacterSelect implements Screen{

    private Game content;
	private ShapeRenderer renderer;
	private HashMap<String, GameFont> fonts;
    private ArrayList<Character> characters;

	private Cursor cursor;

    public CharacterSelect(Game content) {
        this.content = content;
        fonts = new HashMap<>();
    }

    @Override
    public void show() {
		renderer = new ShapeRenderer();
    }
    @Override
    public void render(float delta) {
		renderer.begin(ShapeRenderer.ShapeType.Filled);
		renderer.setColor(200, 200, 200, 255);
		renderer.rect(0, 0, graphics.getWidth(), graphics.getHeight());
		renderer.end();
    }
    @Override
    public void resize(int width, int height) {
        
    }
    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void hide() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void dispose() {
        renderer.dispose();
    }

}
