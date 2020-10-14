package com.example.pictonis;

import java.util.ArrayList;
import java.util.List;

/**
 * bozkur_y and djebar_i
 */
public class Segment {

    private List<Point> points = new ArrayList<Point>();
    private int color;

    // default constructor
    private Segment() {}

    public Segment(int color) {
        this.color = color;
    }

    public void addPoint(int x, int y) {
        Point p = new Point(x, y);
        points.add(p);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getColor() {
        return color;
    }
}
