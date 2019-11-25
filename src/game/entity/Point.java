package game.entity;

public class Point extends Entity {

    private final int DEFAULT_SCORE = 1;

    private int score;

    public Point(int x, int y) {
        super(x, y);
        this.score = DEFAULT_SCORE;
    }

    public int getScore() {
        return score;
    }
}
