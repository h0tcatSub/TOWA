package h0tcat.game.towa.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cursor extends Sprite{
    
    private Texture texture;
    private SpriteBatch batch;
    private Sprite sprite;

    private float x, y, waveX, waveY;
    private double rY;
    private double rX;
    private double deg = 0;
    private int index;

    public Cursor(FileHandle handle){
        texture = new Texture(handle);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        index = 0;
        super.setTexture(texture);
        sprite.setScale(0.3f, 0.3f);
    }

    public Cursor(FileHandle handle, float x, float y){
        this(handle);

        this.x = x;
        this.y = y;
        rX = 0.7;
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

    public void draw(){
        deg += 0.1;
        if(deg >= Double.MAX_VALUE - 100){
            deg = 0;
        }
        waveX = (float) (rX * Math.cos(deg));
        waveY = (float) (rY * Math.sin(deg));
        batch.begin();

        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            y += 29;
        } else if (Gdx.input.isKeyPressed(Keys.UP)) {
            y -= 29;
        }

        sprite.setY(y);
        sprite.translate((float)waveX, (float)waveY);
        sprite.draw(batch);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
