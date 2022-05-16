package h0tcat.game.towa;

import static com.badlogic.gdx.Gdx.graphics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import java.util.HashMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import h0tcat.game.towa.ui.Cursor;
import h0tcat.game.towa.util.GameFont;

public class Main extends ApplicationAdapter {
	private ShapeRenderer renderer;
	private HashMap<String, GameFont> fonts;

	private Cursor cursor;

	@Override
	public void create () {
		renderer = new ShapeRenderer();
		cursor = new Cursor(Gdx.files.internal("data/sysgraphics/ui_arrow.png"), -70, -75);
		cursor.setCenterX(cursor.getWidth() / 2);
		cursor.setCenterY(cursor.getHeight() / 2);
		fonts = new HashMap<String, GameFont>();
		
		fonts.put("title", new GameFont("Towa Engine", graphics.getWidth() / 4 + 50, graphics.getHeight() - 50, Color.BLACK, Color.WHITE));
		fonts.put("1on1", new GameFont("一騎打ち", graphics.getWidth() / 4 + 100, 232, Color.BLACK, Color.WHITE));
		fonts.put("exit", new GameFont("Exit", graphics.getWidth() / 4 + 100, 200, Color.BLACK, Color.WHITE));
		
		renderer.setAutoShapeType(true);
	}

	@Override
	public void render () {
		renderer.begin(ShapeRenderer.ShapeType.Filled);
		renderer.setColor(200, 200, 200, 255);
		renderer.rect(0, 0, graphics.getWidth(), graphics.getHeight());
		renderer.end();
		
		for(GameFont font : fonts.values()){
			font.draw();
		}

		cursor.draw();
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
		for(String key : fonts.keySet()){
			fonts.get(key).dispose();
		}
	}
}