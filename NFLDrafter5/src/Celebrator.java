/**
 * 	Program: Celebrator Interface
 * 	File: Celebrator.java
 * 	Summary: Students will create an interface which the NFLPlayer class will “implement.”
 * 			 This interface will determine the player’s reaction when they are drafted.
 * 	Author: Eric Roberts
 * 	Date: July 30, 2016
 **/
public interface Celebrator {

    //string for celebrations
    public String[] celebrations = { "jumps", "calls mom", "screams in excitement", "crys", "shouts for joy", "smiles", "is going to Disneyland"};

    public String celebrate();
}
