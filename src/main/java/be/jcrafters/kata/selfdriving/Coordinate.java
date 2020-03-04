package be.jcrafters.kata.selfdriving;

public class Coordinate {

    private final int x;
    private final int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordinate{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
