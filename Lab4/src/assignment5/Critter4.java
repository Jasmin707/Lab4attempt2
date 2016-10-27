/* CRITTERS Critter4.java
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

public class Critter4 extends Critter{

	private int dir;
	private int doSwitch;
	private static int babyCounter = 0;
	
	/**
	 * returns string representation of the critter
	 */
	@Override
	public String toString() {
		return "4";
	}
	
	public Critter4(){
		dir = Critter.getRandomInt(8);
	}
	
	
	/**
	 * This method determines what the critter does during each timestep
	 */
	@Override
	public void doTimeStep() {
		if(this.getEnergy() > 100){
			Critter4 child = new Critter4();
			babyCounter++;
			reproduce(child, Critter.getRandomInt(8));
		}
		else {
			doSwitch = Critter.getRandomInt(20);
			if (doSwitch % 2 == 0) {
				switch (dir) {
				case 0:
					dir = 4;
					break;
				case 1:
					dir = 5;
					break;
				case 2:
					dir = 6;
					break;
				case 3:
					dir = 7;
					break;
				case 4:
					dir = 0;
					break;
				case 5:
					dir = 1;
					break;
				case 6:
					dir = 2;
					break;
				case 7:
					dir = 3;
					break;
				}
				walk(dir);
			}
			walk(dir);
		}
	}

	/**
	 * This method determines how the critter acts in a fight
	 */
	@Override
	public boolean fight(String oponent) {
		if (this.getEnergy() > 80){
			return true;
		}
		else{
			walk(dir);
		}
		return false;
	}
	/**
	 * This method prints the stats of Critter4
	 * 
	 * @param critter4s is the list of all living Critter4s
	 */
	public static void runStats(java.util.List<Critter> critter4s) {
		System.out.print("" + critter4s.size() + " total Critter4s    ");
		System.out.println("Total reproductions: " + babyCounter);
	}

}
