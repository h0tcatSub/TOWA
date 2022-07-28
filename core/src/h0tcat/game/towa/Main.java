package h0tcat.game.towa;

import static com.badlogic.gdx.Gdx.graphics;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxRuntimeException;

import h0tcat.game.towa.ui.Title;
import h0tcat.game.towa.util.GameFont;
import h0tcat.game.towa.util.GameSound;

public class Main extends Game {

    private static ArrayList<GameSound> bgm;
    private static ArrayList<String> bgmNames;
	private static HashMap<String, GameFont> fonts;
	
	@Override
	public void create () {
		fonts = new HashMap<>();
  
		File[] musics = new File("data/music/").listFiles();
		bgm = new ArrayList<>();
		bgmNames = new ArrayList<>();

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
            bgm.get(bgmIndex).loop(0.3f);
            String bgmName = ("BGM : ".concat(bgmNames.get(bgmIndex)));
            fonts.put("playingBGM", new GameFont(bgmName, 0, graphics.getHeight(), Color.BLACK, Color.WHITE, 10));
        }
		setScreen(new Title(this));
	}

	public static ArrayList<GameSound> getBgm(){
		return bgm;
	}
	public static ArrayList<String> getBgmNames(){
		return bgmNames;
	}
	public static HashMap<String, GameFont> getFonts(){
		return fonts;
	}

	@Override
	public void render () {
		super.render();
	}
}