/* CRITTERS Encounter.java
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
 */package assignment5;

import java.util.ArrayList;

public class Encounters {
	private int x;
	private int y;
	private ArrayList<Critter> critters = new ArrayList<Critter>();
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public Encounters(int x, int y, ArrayList<Critter> critters) {
		this.x = x;
		this.y = y;
		this.critters = critters;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ArrayList<Critter> getFighters() {
		return critters;
	}
	public void setFighters(ArrayList<Critter> critters) {
		this.critters = critters;
	}
}
