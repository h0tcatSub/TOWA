package h0tcat.game.towa.player.computer;

import java.util.Random;

import h0tcat.game.towa.player.Direction;
import h0tcat.game.towa.player.Fighter;

public class AI {
    private Fighter character;
    private int level = 1;
    private Random random;

    public AI(Fighter character) {
        this.character = character;
        random = new Random();
        random.setSeed(System.currentTimeMillis() + Runtime.getRuntime().freeMemory());
    }

    public AI(Fighter character, int level) {
        this(character);
        this.level = level;
    }

    public void action(Fighter player) {
        double percent = (random.nextDouble() / 1) * 100;
        double distanceX = Math.abs(character.sprite.getX() - player.sprite.getX());
        double distanceY = Math.abs(character.sprite.getY() - player.sprite.getY());
        if (level == 1) {
            if (percent <= 20 && distanceX > 10) {
                if (character.sprite.getX() > player.sprite.getX()){
                    character.dash(Direction.LEFT);
                }else {
                    character.dash(Direction.RIGHT);
                }
            } 
            if (percent <= 25 && distanceY > 15) {
                character.jump();
            }

            if (percent <= 15 && character.isJumping && distanceY < 8 && distanceX < 8) {
                if (character.sprite.getX() > player.sprite.getX()){
                    character.airAttack(Direction.LEFT);
                }else {
                    character.airAttack(Direction.RIGHT);
                }
            }

            if (percent < 40 && distanceX >= 20){
                if (character.sprite.getX() > player.sprite.getX()){
                    character.skilAttack(Direction.LEFT);
                }else{
                    character.skilAttack(Direction.RIGHT);
                }
            }
            if (percent < 40 && distanceY >= 10){
                character.skilAttack(Direction.UP);
            }
            if (percent < 40 && distanceY < 10 || distanceX <= 10){
                character.skilAttack(Direction.DOWN);
            }

            if (percent < 9 && distanceX < 10){
                if (character.sprite.getX() > player.sprite.getX()){
                    character.smash(Direction.LEFT);
                }else{
                    character.smash(Direction.RIGHT);
                }
            }
            
            if (percent < 9 && distanceY < 15){
                if (character.sprite.getY() > player.sprite.getY()){
                    character.smash(Direction.DOWN);
                }else{
                    character.smash(Direction.RIGHT);
                }
            }

            if (percent < 10 && distanceX < 20){
                character.guard();
            }
            
            if (percent < 15 && distanceY < 20){
                character.guard();
            }
        }
    }

}
