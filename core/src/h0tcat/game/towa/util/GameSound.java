package h0tcat.game.towa.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class GameSound implements Sound{
    private Sound sound;
    private long id;

    public GameSound(String soundName) throws GdxRuntimeException{
        sound = Gdx.audio.newSound(Gdx.files.internal(soundName));
    }

    public long getID(){
        return id;
    }
    @Override
    public long play() {
        id = sound.play();
        return id;
    }

    @Override
    public long play(float volume) {
        id = sound.play(volume);
        return id;
    }

    @Override
    public long play(float volume, float pitch, float pan) {
        id = sound.play(volume, pitch, pan);
        return id;
    }

    @Override
    public long loop() {
        id = sound.loop();
        return id;
    }

    @Override
    public long loop(float volume) {
        id = sound.loop(volume);
        return id;
    }

    @Override
    public long loop(float volume, float pitch, float pan) {
        id = sound.loop(volume, pitch, pan);
        return id;
    }

    @Override
    public void stop() {
        sound.stop();
    }

    @Override
    public void pause() {
        sound.pause();
    }

    @Override
    public void resume() {
        sound.resume();
    }

    @Override
    public void dispose() {
        sound.dispose();
    }

    @Override
    public void stop(long soundId) {
        sound.stop(soundId);
    }

    @Override
    public void pause(long soundId) {
        sound.pause(soundId);
    }

    @Override
    public void resume(long soundId) {
        sound.resume(soundId);
    }

    @Override
    public void setLooping(long soundId, boolean looping) {
        sound.setLooping(soundId, looping);
    }

    @Override
    public void setPitch(long soundId, float pitch) {
        sound.setPitch(soundId, pitch);
    }

    @Override
    public void setVolume(long soundId, float volume) {
        sound.setVolume(soundId, volume);
    }

    @Override
    public void setPan(long soundId, float pan, float volume) {
        sound.setPan(soundId, pan, volume);
    }
}
