/* CRITTERS Critter.java
 * EE422C Project 5 submission by
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
package assignment5;

import assignment5.Critter.CritterShape;

/**
 * Critter1 is Snorlax.
 * It moves every 5 turns, and doesn't reproduce.
 * When it fights, it always fights.
 * @author Ethan Cranmer
 *
 */
public class Critter1 extends Critter {
	private int moveCounter;
	private int dir;
	private static boolean hasFought;
	private static int fightsWon;
	private static int timesMoved;
	
	/**
	 * This method returns the number "1" the representation of Snorlax.
	 * 
	 * @return the string representation of Snorlax.
	 */
	@Override 
	public String toString(){ return "1";}
	
	/**
	 * Snorlax moves only once every five turns in a random direction.
	 */
	@Override
	public void doTimeStep() {
		if(hasFought){
			hasFought = false;
			fightsWon++;
		}
		moveCounter = (moveCounter++) % 5;
		dir = Critter.getRandomInt(8);
		if (moveCounter == 4){
			this.walk(dir);
			timesMoved++;
		}
	}

	/**
	 * Snorlax always fights.
	 * 
	 * @param opponent The string representation of the critter Snorlax will fight.
	 */
	@Override
	public boolean fight(String opponent) {
		hasFought = true;
		return true;
	}

	/**
	 * This runs all the the stats of all the Snorlaxes.
	 * 
	 * @param snorlaxes The list of Snorlaxes that are going to be printed.
	 */
	public static String runStats(java.util.List<Critter> snorlaxes){
			String out = new String();
			out = "Stats for " + snorlaxes.size() + " Critter1:\n" +
						"Total Fights Won: " + fightsWon + "\n" +
						"Total Times Moved: " + timesMoved  + "\n";
			return out;
	}


	@Override
	public CritterShape viewShape() { return CritterShape.CIRCLE; }

	@Override
	public javafx.scene.paint.Color viewOutlineColor() { return javafx.scene.paint.Color.BLUE; }
	
}
