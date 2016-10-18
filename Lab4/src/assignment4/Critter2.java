package assignment4;
import assignment4.Critter.TestCritter;

/**
 * Critter2 is Pikachu.
 * It alwaus runs in a random direction and reproduces every 3 turns. Fights all critters but Snorlax.
 * @author Ethan Cranmer
 *
 */
public class Critter2 extends TestCritter {
	private int dir;
	private int moveCounter;
	
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
		dir = Critter.getRandomInt(8);
		this.run(dir);
		moveCounter = (moveCounter++) % 3;
		if( moveCounter == 2){
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
		return true;
	}
}