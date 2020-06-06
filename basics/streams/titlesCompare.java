package com.company.basics.streams;

import java.util.Comparator;

public class titlesCompare implements Comparator<Movies> {
    @Override
    public int compare(Movies o1, Movies o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
