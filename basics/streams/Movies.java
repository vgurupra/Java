package com.company.basics.streams;

public class Movies implements Comparable<Movies> {
    private String title;
    private int likes;
    private Genre genre;

    public Movies(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    @Override
    public int compareTo(Movies other) {
        return this.getLikes() - other.getLikes();
    }

    @Override
    public String toString() {
        return "Movies{" +
                "title='" + title + '\'' +
                ", likes=" + likes +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getLikes() {
        return likes;
    }
}
