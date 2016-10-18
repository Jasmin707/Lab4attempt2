/* CRITTERS Critter2.java
 * EE422C Project 4 submission by
 * Jasmin Rajan
 * jor427
 * 16470
 * Ethan Cranmer
 * elc2255
 * 16475
 * Slip days used: <0>
 * Git URL: https://github.com/Jasmin707/Lab4attempt2
 * Fall 2016
 */
package assignment4;

/**
 * Critter2 is Pikachu.
 * It alwaus runs in a random direction and reproduces every 3 turns. Fights all critters but Snorlax.
 * @author Ethan Cranmer
 *
 */
public class Critter2 extends Critter {
	private int dir;
	private int moveCounter;
	private boolean hasFought;
	private int fightsWon;
	private int timesMoved;
	private int pikachusHatched;
	
	/**
	 * This function returns the string representation of Pikachu.
	 * 
	 * @return the string representation of Pikachu.
	 */
	@Override 
	public String toString(){ return "2";}
		
	/**
	 * Pikachu always runs in a random direction and reproduces every 3 turns.
	 */
	@Override
	public void doTimeStep() {
		if(hasFought){
			hasFought = false;
			fightsWon++;
		}
		dir = Critter.getRandomInt(8);
		this.run(dir);
		moveCounter = (moveCounter++) % 3;
		timesMoved++;
		if( moveCounter == 2){
			pikachusHatched++;
			Critter2 babyPika = new Critter2();
			reproduce(babyPika, Critter.getRandomInt(8));
		}
	}

	/**
	 * Pikachu fights all other Critters except for Snorlax Critters.
	 * 
	 * @param opponent The string representation of the Critter that will be fought.
	 * @return whether or not it will fight the opposing Critter
	 */
	@Override
	public boolean fight(String opponent) {
		if(opponent.equals("1")){
			this.run(dir);
			return false;
		}
		hasFought = true;
		return true;
	}
	
	/**
	 * This runs all the the stats of all the Pikachus.
	 * 
	 * @param pikachus The list of Pikachus that are going to be printed.
	 */
	public static void runStats(java.util.List<Critter> pikachus){
		for(int i = 0; i < pikachus.size(); i++){
			System.out.println("Stats for Pikachu " + i + ":");
			System.out.println("Fights won: " + ((Critter2)pikachus.get(i)).fightsWon );
			System.out.println("Times Moved: " + ((Critter2)pikachus.get(i)).timesMoved );
			System.out.println("Baby Pikachus Hatched: " + ((Critter2)pikachus.get(i)).pikachusHatched );
		}
	}
}
