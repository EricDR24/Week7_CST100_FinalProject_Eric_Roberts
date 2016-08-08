/**
 * Program: Celebrator Interface
 * File: OffensivePlayer.java
 * Summary: Students will create an interface which the NFLPlayer class will “implement.”
 * This interface will determine the player’s reaction when they are drafted.
 * Author: Eric Roberts
 * Date: July 30, 2016
 **/

import java.util.Random;

public class OffensivePlayer extends NFLPlayer implements Celebrator {
    //data fields
    private int touchDowns;
    private int interceptions;
    private double yards;
    private double rating;
    private int carries;
    private double rushAverageYards;
    private int receptions;
    private double receptionAverageYards;

    public OffensivePlayer() {

    }

    //constructor
    public OffensivePlayer(String name, String position, NFLTeam team, int number, double height, double weight, int age, String College, int experience, int touchDowns, int interceptions, double yards, double rating, int carries, double rushAverageYards, int receptions, double receptionAverageYards) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.number = number;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.College = College;
        this.experience = experience;
        this.touchDowns = touchDowns;
        this.interceptions = interceptions;
        this.yards = yards;
        this.rating = rating;
        this.carries = carries;
        this.rushAverageYards = rushAverageYards;
        this.receptions = receptions;
        this.receptionAverageYards = receptionAverageYards;
    }

    //getters
    @Override
    public String getName() {
        return this.name + " (O)";
    }


    public int getTouchDowns() {
        return touchDowns;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public double getYards() {
        return yards;
    }

    public double getRating() {
        return rating;
    }

    public int getCarries() {
        return carries;
    }

    public double getRushAverageYards() {
        return rushAverageYards;
    }

    public int getReceptions() {
        return receptions;
    }

    public double getReceptionAverageYards() {
        return receptionAverageYards;
    }

    //setters
    public void setTouchDowns(int playerTouchDowns) {
        touchDowns = playerTouchDowns;
    }

    public void setInterceptions(int playerInterceptions) {
        interceptions = playerInterceptions;
    }

    public void setYards(double playerYards) {
        yards = playerYards;
    }

    public void setRating(double playerRating) {
        rating = playerRating;
    }

    public void setCarries(int playerCarries) {
        carries = playerCarries;
    }

    public void setRushAverageYards(double playerRushAverageYards) {
        rushAverageYards = playerRushAverageYards;
    }

    public void setReceptions(int playerReceptions) {
        receptions = playerReceptions;
    }

    public void setReceptionsAverageYards(double playerRecptionsAverageYards) {
        receptionAverageYards = playerRecptionsAverageYards;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public String getStats() {
        return "Touch Downs: 10 \nCatches: 20 \nCarries: 35 \nYards: 2009 \nCompletions: 89 \nAverage Yards Per Run: 5.3" +
                "\nReceptions: 35 \nRating: 89 \nAge: 29 \nCollege: Arizona State University \nHeight: 6' 2 \nWeight: 225" +
                "\nExperience: 3 \nYards after contact: 12 \nAverage Yards per Reception: 23 \nInterceptions: 11";
    }
}

