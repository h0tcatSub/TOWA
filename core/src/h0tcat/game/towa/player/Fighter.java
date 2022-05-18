package h0tcat.game.towa.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Fighter extends Character{
    public Sprite sprite;
    public SpriteBatch batch;
    public boolean isJump;
    public int jumpLimit;
    public int smashSpeed, stunTime, shieldPower;
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
}
