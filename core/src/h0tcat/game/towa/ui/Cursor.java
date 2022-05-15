package h0tcat.game.towa.ui;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cursor extends Sprite{
    
    private Texture texture;
    private SpriteBatch batch;
    private Sprite sprite;

    private float x, y;
    
    public Cursor(FileHandle handle){
        texture = new Texture(handle);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        
        super.setTexture(texture);
        sprite.setScale(0.3f, 0.3f);
    }

    public Cursor(FileHandle handle, float x, float y){
        this(handle);

        this.x = x;
        this.y = y;
        move(x, y);
    }

    public Cursor(FileHandle handle, float x, float y, float originX, float originY){
        this(handle, x, y);
        super.setOrigin(originX, originY);

        this.x = x;
        this.y = y;
    }


    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }

    public void move(float x, float y) {
        this.x = x;
        this.y = y;
        sprite.translate(x, y);
    }

    public void draw(){
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
