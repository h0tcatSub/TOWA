package h0tcat.game.towa.player;

public abstract class Character {
    /**
     * attackメソッド
     * キャラクターが攻撃をします。
     */
    public abstract void attack(Direction direction);
    public abstract void airAttack(Direction direction);
    public abstract void skilAttack(Direction direction);
    public abstract void damage();
    public abstract void walk(Direction direction);
    public abstract void dash(Direction direction);
    public abstract void smash(Direction direction);
    public abstract void jump();
    public abstract void squat();
    public abstract void grab();
    public abstract void throwChara();
    public abstract void guard();
    
    public abstract void stun();
    public abstract void smashed();
}