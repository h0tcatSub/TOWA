package h0tcat.game.towa.player;

public abstract class Character {
    /**
     * attackメソッド
     * キャラクターが攻撃をします。
     * @param direction 攻撃する方向
     */
    public abstract void attack(Direction direction);
    /**
     * airAttackメソッド
     * 空中にキャラクターがいる際の攻撃メソッドです
     * @param direction 攻撃する方向
     */
    public abstract void airAttack(Direction direction);
    /**
     * skilAttackメソッド
     * 方向に応じて必殺技攻撃をします
     * @param direction 攻撃する方向
     */
    public abstract void skilAttack(Direction direction);
    /**
     * damageメソッド
     * 相手からダメージを受けた際の処理です。
     */
    public abstract void damage();
    /**
     * walkメソッド
     * キャラクターを歩かせます。
     * @param direction 横方向のどちらかを指定します。
     */
    public abstract void walk(Direction direction);
    /**
     * dashメソッド
     * キャラクターを走らせます。
     * @param direction 横方向のどちらかを指定します。
     */
    public abstract void dash(Direction direction);
    /**
     * smashメソッド
     * スマッシュ攻撃を発動させます
     * @param direction 攻撃する方向
     */
    public abstract void smash(Direction direction);

    /**
     * dashメソッド
     * キャラクターをジャンプさせます。
     */
    public abstract void jump();
    /**
     * squatメソッド
     * キャラクターをしゃがませます。
     */
    public abstract void squat();
    /**
     * grabメソッド
     * つかみ処理を発動させます。
     */
    
    public abstract void grab();
    /**
     * throwcharaメソッド
     * つかみ成功後、directionパラメーターの方向に投げます。
     * @param direction 投げる方向
     */
    public abstract void throwChara(Direction direction);
    
    /**
     * guardメソッド
     * シールドを出します
     */
    public abstract void guard();
    
    /**
     * stunメソッド
     * シールドが壊れたしたときなどに気絶する処理です。
     */
    public abstract void stun();
    /**
     * smashedメソッド
     * 自分が相手に吹っ飛ばされたときに発動させます。
     */
    public abstract void smashed();
}