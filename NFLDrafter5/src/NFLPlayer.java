/**
 * 	Program: Celebrator Interface
 * 	File: Celebrator.java
 * 	Summary: Students will create an interface which the NFLPlayer class will “implement.”
 * 			 This interface will determine the player’s reaction when they are drafted.
 * 	Author: Eric Roberts
 * 	Date: July 30, 2016
 **/


import java.util.Random;

public abstract class NFLPlayer implements Celebrator {
    //player info
    protected String name;
    protected String position;
    protected NFLTeam team;
    protected int number;
    protected double height;
    protected double weight;
    protected int age;
    protected String College;
    protected int experience;

    public boolean isDrafted = false;

    //celebrate
    public String celebrate() {
        //random celebrate
        int celebrateRandom = new Random().nextInt(Celebrator.celebrations.length);
        String randomCelebrate = (Celebrator.celebrations[celebrateRandom]);
        //print celebration
        return this.name + " " + randomCelebrate + " to celebrate!";
    }

    //getters for Player info
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public NFLTeam getTeam() {
        return team;
    }

    public int getNumber() {
        return number;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getCollege() {
        return College;
    }

    public int getExperience() {
        return experience;
    }

    //setters for Player info
    public void setName(String playerName) {
        name = playerName;
    }

    public void setPosition(String playerPosition) {
        position = playerPosition;
    }

    public void setTeam(NFLTeam playerTeam) {
        team = playerTeam;
    }

    public void setNumber(int playerNumber) {
        number = playerNumber;
    }

    public void setHeight(double playerHeight) {
        height = playerHeight;
    }

    public void setWeight(double playerWeight) {
        weight = playerWeight;
    }

    public void setAge(int playerAge) {
        age = playerAge;
    }

    public void setCollege(String playerCollege) {
        College = playerCollege;
    }

    public void setExperience(int playerExperience) {
        experience = playerExperience;
    }

    NFLPlayer() {

    }

    NFLPlayer(String name, String position, String team, int number, double height, double weight, int age, String College, int experience) {

    }

    public abstract String getStats();
}


