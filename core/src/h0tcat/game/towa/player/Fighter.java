package h0tcat.game.towa.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Fighter extends Character{
    public String id;
    public Sprite sprite;
    public SpriteBatch batch;
    public boolean isJumping, isSquat;
    public int jumpLimit, stock;
    public float x,y;
    public float speed;
    public float weight;
    public float ultimateAttackPower;
    public boolean superArmor;
    public boolean isUltimate;

    public int smashSpeed, stunTime, shieldPower;

    public float getX(){
        return sprite.getX();
    }
    public float getY(){
        return sprite.getY();
    }
}