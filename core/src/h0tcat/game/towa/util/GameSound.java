package h0tcat.game.towa.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class GameSound {
    private final String soundDirectory = "data/syssnd/";
    private Music sound;

    public GameSound(String soundName){
        sound = Gdx.audio.newMusic(Gdx.files.internal(soundDirectory.concat(soundName)));
    }

    public boolean play(){
        sound.play();
        return sound.isPlaying();
    }
    public boolean loop(){
        if(sound == null){
            return false;
        }
        sound.setLooping(true);
        return true;
    }
}
