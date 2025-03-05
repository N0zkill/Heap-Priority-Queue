package org.example.heapsort;

public class Player {
    private String name;
    private int score;

    // Default constructor
    public Player() {
        this.name = "";
        this.score = 0;
    }

    // Parameterized
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Deep Copy
    public Player(Player two) {
        this.name = two.name;
        this.score = two.score;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Deep copy
    public Player createClone() {
        return new Player(this);
    }


    // display players and scores
    @Override
    public String toString() {
        return "Player name='" + name + "', score=" + score ;
    }
}
