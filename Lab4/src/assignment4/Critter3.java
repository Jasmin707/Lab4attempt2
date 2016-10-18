/* CRITTERS Critter3.java
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

public class Critter3 extends Critter{

	private int dir;
	
	/**
	 * returns string representation of the critter
	 */
	@Override
	public String toString() { return "J"; }
	
	public Critter3(){
		dir = Critter.getRandomInt(8);
		
	}
	
	/**
	 * This method determines what the critter does during each timestep
	 */
	@Override
	public void doTimeStep() {
		 if (this.getEnergy() > 180){
			 Critter3 child = new Critter3();
			 reproduce(child, Critter.getRandomInt(8));
		 }
		 else{
			 walk((dir + 1) % 8);
		 }
		
	}

	/**
	 * This method determines how the critter acts in a fight
	 */
	@Override
	public boolean fight(String opponent) {
		if (opponent.equals("@") || this.getEnergy() > 100) {
			return true;
		}
		else {
			walk(dir);
		}
		return false;
	}

}
