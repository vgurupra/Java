package com.company.basics.generics;

public class User implements Comparable<User> {
    private int points;
    public User(int points){
        this.points = points;
    }

    @Override
    public int compareTo(User other) {
        return this.points - other.points;
    }

    @Override
    public String toString() {
        return "User{" +
                "points=" + points +
                '}';
    }
}
