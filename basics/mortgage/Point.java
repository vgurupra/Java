package com.company.basics;

import java.util.Objects;

public class Point {
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point add(Point other){
        return new Point(x + other.x, y + other.y);
    }

    public Point subtract(Point other){
        return new Point(x - other.x, y - other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}