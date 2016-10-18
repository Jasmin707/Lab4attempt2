package assignment4;
import assignment4.Critter.TestCritter;

public class Critter2 extends TestCritter {
	private int dir;
	
	@Override 
	public String toString(){ return "1";}
	
	//This is snorlax, it moves every 5 turns
	@Override
	public void doTimeStep() {
		
	}

	@Override
	public boolean fight(String oponent) {
		setEnergy(getEnergy() + 100);
		return true;
	}
}
