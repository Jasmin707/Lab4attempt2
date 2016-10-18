package assignment4;
import assignment4.Critter.TestCritter;

public class Critter1 extends TestCritter {
	private int moveCounter;
	private int dir;
	
	@Override 
	public String toString(){ return "1";}
	
	//This is snorlax, it moves every 5 turns
	@Override
	public void doTimeStep() {
		moveCounter = (moveCounter++) % 5;
		dir = Critter.getRandomInt(8);
		if (moveCounter == 4){
			this.walk(dir);
		}
	}

	@Override
	public boolean fight(String oponent) {
		setEnergy(getEnergy() + 100);
		return true;
	}

}
