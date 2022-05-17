package h0tcat.game.towa.ui.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cursor extends Sprite{
    
    private SpriteBatch batch;

    private float waveX, waveY;
    private double rY;
    private double rX;
    private double deg = 0;

    public Cursor(Texture texture){
        super(texture);
        batch = new SpriteBatch();

        super.setTexture(texture);
        super.setScale(0.3f, 0.3f);
    }

    public Cursor(Texture texture, float x, float y){
        this(texture);

        setX(x);
        setY(y);
        rX = 1;
        rY = 0.01;
    }

    public Cursor(Texture texture, float x, float y, float originX, float originY){
        this(texture, x, y);
        super.setOrigin(originX, originY);
    }
    
    @Override
    public void setX(float x){
        super.setX(x);
    }
    @Override
    public void setY(float y){
        super.setY(y);
    }
    @Override
    public float getX(){
        return super.getX();
    }
    @Override
    public float getY(){
        return super.getY();
    }
    public void calcWave(){
        deg += 0.1;
        if(deg >= Double.MAX_VALUE - 100){
            deg = 0;
        }
        waveX = (float) (rX * Math.cos(deg));
        waveY = (float) (rY * Math.sin(deg));
    }

    
    public void draw(){

        calcWave();
        batch.begin();
        super.translate((float)waveX, (float)waveY);
        super.draw(batch);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }
}
