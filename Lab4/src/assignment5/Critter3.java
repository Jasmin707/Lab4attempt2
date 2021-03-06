/* CRITTERS Critter3.java
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

public class Critter3 extends Critter{

	private int dir;
	private static int babyCounter = 0;
	
	/**
	 * returns string representation of the critter
	 */
	@Override
	public String toString() { return "3"; }
	
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
			 babyCounter++;
			 reproduce(child, Critter.getRandomInt(8));
		 }
		 else{
			int direction = Critter.getRandomInt(8);
			if (this.look(direction, false) != null) {
				if (this.look(direction, false).equals("@")) {
					walk(direction);
				} else if (this.look(direction, false).equals("1")) {
					walk((direction + 4) % 8);
				}
			}else {
				walk(direction);
			}
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
	
	/**
	 * This method prints the stats of Critter3
	 * 
	 * @param critter4s is the list of all living Critter3s
	 */
	public static String runStats(java.util.List<Critter> critter3s) {
		String out = new String();
		out = "" + critter3s.size() + " total Jasmins    \n" +
		"Total reproductions: " + babyCounter;
		return out;
	}

	@Override
	public CritterShape viewShape() { return CritterShape.STAR; }

	@Override
	public javafx.scene.paint.Color viewOutlineColor() { return javafx.scene.paint.Color.GOLDENROD; }
	
	@Override
	public javafx.scene.paint.Color viewFillColor() { return javafx.scene.paint.Color.BLUEVIOLET; }

}
