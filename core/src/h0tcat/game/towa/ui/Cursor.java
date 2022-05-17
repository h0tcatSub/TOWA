package h0tcat.game.towa.ui;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import h0tcat.game.towa.util.GameSound;

public class Cursor extends Sprite{
    
    private Texture texture;
    private SpriteBatch batch;
    private Sprite sprite;

    private float x, y, waveX, waveY;
    private double rY;
    private double rX;
    private double deg = 0;
    private int index = 0, indexBuf;
    private final int defaultPosition = -75;
    private final int maxOptions = 2;
    private HashMap<String, GameSound> sounds;

    public Cursor(FileHandle handle){
        texture = new Texture(handle);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        index = 0;

        sounds = new HashMap<>();
        sounds.put("select", new GameSound("select.mp3"));
        sounds.put("exit", new GameSound("enter.mp3"));

        super.setTexture(texture);
        sprite.setScale(0.3f, 0.3f);
    }

    public Cursor(FileHandle handle, float x, float y){
        this(handle);

        this.x = x;
        this.y = y;
        rX = 5;
        rY = 0.01;
    }

    public Cursor(FileHandle handle, float x, float y, float originX, float originY){
        this(handle, x, y);
        super.setOrigin(originX, originY);
    }


    public float getX(){
        return (float) x;
    }
    public float getY(){
        return (float) y;
    }

    public void move(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void calcWave(){
        deg += 0.1;
        if(deg >= Double.MAX_VALUE - 100){
            deg = 0;
        }
        waveX = (float) (rX * Math.cos(deg));
        waveY = (float) (rY * Math.sin(deg));
    }

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
        indexBuf = index;
        index %= maxOptions;
        if(indexBuf > maxOptions){
            index = maxOptions - 1;
        }else if(indexBuf < 0) {
            index = maxOptions - 1;
        }

        switch(index){
            case 0:
                y = defaultPosition;
                break;
            case 1:
                y = defaultPosition - 32;
                break;
        }
        sprite.setX(x);
        sprite.setY(y);
    }
    
    public void draw(){

        calcWave();
        batch.begin();
        selectCommand();
        sprite.translate((float)waveX, (float)waveY);
        sprite.draw(batch);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
