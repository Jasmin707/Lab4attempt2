package assignment4;
import assignment4.Critter.TestCritter;

/**
 * Critter1 is Snorlax.
 * It moves every 5 turns, and doesn't reproduce.
 * When it fights, it automatically gains 100 energy and then always fights.
 * @author Ethan Cranmer
 *
 */
public class Critter1 extends TestCritter {
	private int moveCounter;
	private int dir;
	
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
		moveCounter = (moveCounter++) % 5;
		dir = Critter.getRandomInt(8);
		if (moveCounter == 4){
			this.walk(dir);
		}
	}

	/**
	 * Snorlax gains 100 energy and then always fights.
	 * 
	 * @param opponent The string representation of the critter Snorlax will fight.
	 */
	@Override
	public boolean fight(String opponent) {
		setEnergy(getEnergy() + 100);
		return true;
	}

}
