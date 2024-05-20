package com.example.hw_12.Model;

public class Score {
    public String name;
    public int score;
    public double lat;
    public double lon;

    public Score(String name, int score, double lat, double lon) {
        this.name = name;
        this.score = score;
        this.lat = lat;
        this.lon = lon;
    }

    public Score() {
    }

    public String getName() {
        return name;
    }

    public Score setName(String name) {
        this.name = name;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Score setScore(int score) {
        this.score = score;
        return this;
    }

    public double getLat() {
        return lat;
    }

    public Score setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLon() {
        return lon;
    }

    public Score setLon(double lon) {
        this.lon = lon;
        return this;
    }
}
