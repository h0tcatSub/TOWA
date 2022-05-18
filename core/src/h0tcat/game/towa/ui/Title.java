package h0tcat.game.towa.ui;

import static com.badlogic.gdx.Gdx.graphics;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.util.Random;
import h0tcat.game.towa.ui.util.Cursor;
import h0tcat.game.towa.util.GameFont;
import h0tcat.game.towa.util.GameSound;

public class Title implements Screen{

	private ShapeRenderer renderer;
	private HashMap<String, GameFont> fonts;
    private HashMap<String, GameSound> sounds;
    private ArrayList<GameSound> bgm;

	private Cursor cursor;
    private int index = 0, indexBuf, maxOptions = 2;
    private final int defaultPosition = -75;
    private ArrayList<String> bgmNames;

    public void selectCommand(){
        if(index >= Integer.MAX_VALUE -100){
            index = 0;
        }
        if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
            sounds.get("select").play(1.f, 0.7f, 0.f);
            index++;
        } else if (Gdx.input.isKeyJustPressed(Keys.UP)) {
            sounds.get("select").play(1.f, 0.7f, 0.f);
            index--;
        }
        if(Gdx.input.isKeyJustPressed(Keys.ENTER)){
            sounds.get("enter").play(1.f, 0.7f, 0.f);
            enterCommand();
        }
        indexBuf = index;
        index %= maxOptions;
        if(indexBuf > maxOptions){
            index = maxOptions - 1;
        }else if(indexBuf < 0) {
            index = maxOptions - 1;
        }

        switch(index){
            case 0:
                cursor.setY(defaultPosition);
                break;
            case 1:
                cursor.setY(defaultPosition - 32);
                break;
        }
        cursor.setY(cursor.getY());
    }

    public void enterCommand(){
        switch(index){
            case 0:

                break;
            case 1:
                renderer.dispose();
                for(String key : fonts.keySet()){
                    fonts.get(key).dispose();
                }
                Gdx.app.exit();
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;                
        }
    }
    @Override
    public void show() {
		renderer = new ShapeRenderer();
		fonts = new HashMap<>();
		cursor = new Cursor(new Texture(Gdx.files.internal("data/sysgraphics/ui_arrow.png")), -30, -75);
        sounds = new HashMap<>();
        bgm = new ArrayList<>();
        bgmNames = new ArrayList<>();

        File[] musics = new File("data/music/").listFiles();
        if(musics.length > 0){
            for(File music : musics){
                try{
                    bgm.add(new GameSound(music.getPath()));
                    bgmNames.add(music.getName());
                } catch(GdxRuntimeException notMusic){
                    notMusic.printStackTrace();
                }
            }
        }
        if(bgm.size() > 0){
            Random random = new Random();
            int bgmIndex = random.nextInt(bgm.size());
            bgm.get(bgmIndex).play(0.3f);
            String bgmName = ("BGM : ".concat(bgmNames.get(bgmIndex)));
            fonts.put("plaingBGM", new GameFont(bgmName, 0, graphics.getHeight(), Color.BLACK, Color.WHITE, 10));
        }
        index = 0;

        sounds.put("select", new GameSound("data/syssnd/select.mp3"));
        sounds.put("enter", new GameSound("data/syssnd/enter.mp3"));
		
		fonts.put("title", new GameFont("Towa Engine", graphics.getWidth() / 4 + 50, graphics.getHeight() - 50, Color.BLACK, Color.WHITE));
		fonts.put("1on1", new GameFont("一騎打ち", graphics.getWidth() / 4 + 100, 232, Color.BLACK, Color.WHITE));
		fonts.put("exit", new GameFont("Exit", graphics.getWidth() / 4 + 100, 200, Color.BLACK, Color.WHITE));
		renderer.setAutoShapeType(true);
    }

    @Override
    public void render(float delta) {
		renderer.begin(ShapeRenderer.ShapeType.Filled);
		renderer.setColor(200, 200, 200, 255);
		renderer.rect(0, 0, graphics.getWidth(), graphics.getHeight());
		renderer.end();
		
		for(GameFont font : fonts.values()){
			font.draw();
		}

        selectCommand();
		cursor.draw();
        
    }
    
    @Override
    public void dispose() {
		renderer.dispose();
		for(String key : fonts.keySet()){
			fonts.get(key).dispose();
		}
    }
    
    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}
}
