import java.util.Random;

/**
 * 	Program: Celebrator Interface
 * 	File: DefensivePlayer.java
 * 	Summary: Students will create an interface which the NFLPlayer class will “implement.”
 * 		     This interface will determine the player’s reaction when they are drafted.
 * 	Author: Eric Roberts
 * 	Date: July 30, 2016
 **/
public class DefensivePlayer extends NFLPlayer implements Celebrator {
    private double tackels;
    private double sacks;
    private int forcedFumbles;

    public DefensivePlayer() {

    }

    public DefensivePlayer(String name, String position, NFLTeam team, int number, double height, double weight, int age, String College, int experience, double tackels, double sacks, int forcedFumbles) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.number = number;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.College = College;
        this.experience = experience;
        this.tackels = tackels;
        this.sacks = sacks;
        this.forcedFumbles = forcedFumbles;

    }

    //getters
    @Override
    public String getName() {
        return this.name + " (D)";
    }


    public double getSacks() {
        return sacks;
    }

    public double getTackels() {
        return tackels;
    }

    public int getForcedFumbles() {
        return forcedFumbles;
    }

    //setters
    public void setTackels(double playerTackels) {
        tackels = playerTackels;
    }

    public void setSacks(double playerSacks) {
        sacks = playerSacks;
    }

    public void setForcedFumbles(int playerForcedFumbles) {
        forcedFumbles = playerForcedFumbles;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public String getStats() {
        return "Sacks: 3 \nTackles: 21 \nForces Fumbles: 4 \nInceptions: 4 \nExperience: 3 \nCollege: Arizona State University" +
                "\nHeight: 6' 3 \nWeight: 230 \nAge: 30 \nField Goal Blocks: 4 \nPunt Blocks: 6 \nLoss of Yards Tackles: 5" ;
    }
}

