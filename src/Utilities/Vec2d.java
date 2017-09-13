package Utilities;

public class Vec2d {
    public int x;
    public int y;
    Vec2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vec2d other) {
        x += other.x;
        y += other.y;
    }
}
