/* CRITTERS OldCoord.java
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

public class OldCoord {
	private int oldX;
	private int oldY;
	private Critter crt;
	
	OldCoord(int x, int y, Critter crt){
		oldX = x;
		oldY = y;
		this.crt = crt;
	}

	/**
	 * @return the oldX
	 */
	public int getOldX() {
		return oldX;
	}

	/**
	 * @return the oldY
	 */
	public int getOldY() {
		return oldY;
	}

	/**
	 * @return the crt
	 */
	public Critter getCrt() {
		return crt;
	}

}
