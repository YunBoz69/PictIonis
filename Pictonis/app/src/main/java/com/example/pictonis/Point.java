package com.example.pictonis;

/**
 * bozkur_y and djebar_i
 */
public class Point {
    int x;
    int y;

    //  default constructor
    @SuppressWarnings("unused")
    private Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
