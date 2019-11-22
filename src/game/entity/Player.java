package game.entity;

public class Player extends Entity {

    private int score = 0;
    private int life;

    private static final int DEFAULT_LIFE_NUMBER = 3;

    public Player(int x, int y) {
        super(x, y);
        life = DEFAULT_LIFE_NUMBER;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }


}
