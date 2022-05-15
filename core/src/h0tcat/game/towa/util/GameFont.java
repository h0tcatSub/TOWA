package h0tcat.game.towa.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameFont {
    private FileHandle file;

	private SpriteBatch sprite;
	private BitmapFont font;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private String text;
    private float x, y;

    public GameFont(String text, int x, int y, Color color, Color borderColor){
		file = Gdx.files.internal("data/sysfonts/nicokaku_v1.ttf");
        this.x = x;
        this.y = y;
        this.text = text;

        generator = new FreeTypeFontGenerator(file);
		parameter = new FreeTypeFontParameter();
		sprite = new SpriteBatch();
		
        parameter.color = color;
        parameter.borderColor = borderColor;
		parameter.size = 32;
		
		font = generator.generateFont(parameter);
    }

    public void draw(){
        sprite.begin();
        font.draw(sprite, text, x, y);
        sprite.end();        
    }

    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public float getX(float x){
        return x;
    }
    public float getY(float y){
        return y;
    }

    public void dispose(){
        sprite.dispose();
        font.dispose();
		generator.dispose();
    }
}
