package com.company.basics.streams;

import java.util.Comparator;

public class likesCompare implements Comparator<Movies> {
    @Override
    public int compare(Movies o1, Movies o2) {
        return o1.getLikes() - o2.getLikes();
    }
}
