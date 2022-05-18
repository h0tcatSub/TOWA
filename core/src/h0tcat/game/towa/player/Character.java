package h0tcat.game.towa.core.player;

public abstract class Character {
    /**
     * attackメソッド
     * キャラクターが攻撃をします。
     * 
     */
    public abstract void attack();
    public abstract void walk();
    public abstract void dash();
    public abstract void meteor();
    public abstract void smash();
    public abstract void jump();
    public abstract void squat();
    public abstract void grab();
    public abstract void throwChara();
    public abstract void guard();
    public abstract void stun();
}