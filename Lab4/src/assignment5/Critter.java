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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.shape.*;
import javafx.stage.Stage;

/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */

public abstract class Critter {
	/* NEW FOR PROJECT 5 */
	public enum CritterShape {
		CIRCLE,
		SQUARE,
		TRIANGLE,
		DIAMOND,
		STAR
	}
	
	/* the default color is white, which I hope makes critters invisible by default
	 * If you change the background color of your View component, then update the default
	 * color to be the same as you background 
	 * 
	 * critters must override at least one of the following three methods, it is not 
	 * proper for critters to remain invisible in the view
	 * 
	 * If a critter only overrides the outline color, then it will look like a non-filled 
	 * shape, at least, that's the intent. You can edit these default methods however you 
	 * need to, but please preserve that intent as you implement them. 
	 */
	public javafx.scene.paint.Color viewColor() { 
		return javafx.scene.paint.Color.WHITE; 
	}
	
	public javafx.scene.paint.Color viewOutlineColor() { return viewColor(); }
	public javafx.scene.paint.Color viewFillColor() { return viewColor(); }
	
	public abstract CritterShape viewShape(); 

	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}
	
	protected String look(int direction, boolean steps) {
		int tempX = 0, tempY = 0;
		this.energy -= Params.look_energy_cost;
		//checks if it commited sudoku looking
		if (this.energy <=0){
			population.remove(this);
		}
		//get tempX and tempY
		if(!steps){
			switch (direction) {
			case 0:
				tempX = (this.x_coord + 1) % Params.world_width;
				break;
			case 1:
				tempX = (this.x_coord + 1) % Params.world_width;
				tempY = this.y_coord - 1;
				if (tempY < 0) {
					tempY += Params.world_height;
				}
				break;
			case 2:
				tempY = this.y_coord - 1;
				if (tempY < 0) {
					tempY += Params.world_height;
				}
				break;
			case 3:
				tempX = this.x_coord - 1;
				if (tempX < 0) {
					tempX += Params.world_width;
				}
				tempY = this.y_coord - 1;
				if (tempY < 0) {
					tempY += Params.world_height;
				}
				break;
			case 4:
				tempX = this.x_coord - 1;
				if (tempX < 0) {
					tempX += Params.world_width;
				}
				break;
			case 5:
				tempX = this.x_coord - 1;
				if (tempX < 0) {
					tempX += Params.world_width;
				}
				tempY = (this.y_coord + 1) % Params.world_height;
				break;
			case 6:
				tempY = (this.y_coord + 1) % Params.world_height;
				break;
			case 7:
				tempX = (this.x_coord + 1) % Params.world_width;
				tempY = (this.y_coord + 1) % Params.world_height;
				break;
			}
		}else{
			switch (direction) {
			case 0:
				tempX = (this.x_coord + 2) % Params.world_width;
				break;
			case 1:
				tempX = (this.x_coord + 2) % Params.world_width;
				tempY = this.y_coord - 2;
				if (tempY < 0) {
					tempY += Params.world_height;
				}
				break;
			case 2:
				tempY = this.y_coord - 2;
				if (tempY < 0) {
					tempY += Params.world_height;
				}
				break;
			case 3:
				tempX = this.x_coord - 2;
				if (tempX < 0) {
					tempX += Params.world_width;
				}
				tempY = this.y_coord - 2;
				if (tempY < 0) {
					tempY += Params.world_height;
				}
				break;
			case 4:
				tempX = this.x_coord - 2;
				if (tempX < 0) {
					tempX += Params.world_width;
				}
				break;
			case 5:
				tempX = this.x_coord - 2;
				if (tempX < 0) {
					tempX += Params.world_width;
				}
				tempY = (this.y_coord + 2) % Params.world_height;
				break;
			case 6:
				tempY = (this.y_coord + 2) % Params.world_height;
				break;
			case 7:
				tempX = (this.x_coord + 2) % Params.world_width;
				tempY = (this.y_coord + 2) % Params.world_height;
				break;
			}
		}
		
		//check if there is a critter at tempX and tempY
		for(Critter crt : population){
			if((crt.x_coord == tempX) && (crt.y_coord == tempY)){
				return crt.toString();
			}
		}
		
		return null;
	}
	
	private static String myPackage;
	private	static List<Critter> population = new java.util.ArrayList<Critter>();
	private static List<Critter> babies = new java.util.ArrayList<Critter>();
	
	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}
	
	private static java.util.Random rand = new java.util.Random();
	
	/**
	 * This function gives a random number from 0-(max - 1); 
	 * 
	 * @param max the maximum number that a function can have
	 * @return the random number
	 */
	public static int getRandomInt(int max) {
		return rand.nextInt(max);
	}
	
	/**
	 * Sets a seed that will be used by the random function.
	 * 
	 * @param new_seed the seed value to be set
	 */
	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}
	
	
	/* a one-character long string that visually depicts your critter in the ASCII interface */
	@Override
	public String toString() { return ""; }
	
	private int energy = 0;
	
	/**
	 * This function returns the energy of a critter.
	 * 
	 * @return the energy of the critter that calls this function.
	 */
	protected int getEnergy() { return energy; }

	private int x_coord;
	private int y_coord;
	private boolean hasMoved;
	private boolean inFight;
	private static double size = 15;
	
	/**
	 * The critter that calls this function will be moved in the specified direction and will have the appropriate energy subtracted.
	 * 
	 * @param direction that the critter will move in
	 */
	protected final void walk(int direction) {
		int tempX = -1;
		int tempY = -1;
		boolean canMove = true;
		if (!this.hasMoved) {
			if (this.inFight) {
				switch (direction) {
				case 0:
					tempX = (this.x_coord + 1) % Params.world_width;
					break;
				case 1:
					tempX = (this.x_coord + 1) % Params.world_width;
					tempY = this.y_coord - 1;
					if (tempY < 0) {
						tempY += Params.world_height;
					}
					break;
				case 2:
					tempY = this.y_coord - 1;
					if (tempY < 0) {
						tempY += Params.world_height;
					}
					break;
				case 3:
					tempX = this.x_coord - 1;
					if (tempX < 0) {
						tempX += Params.world_width;
					}
					tempY = this.y_coord - 1;
					if (tempY < 0) {
						tempY += Params.world_height;
					}
					break;
				case 4:
					tempX = this.x_coord - 1;
					if (tempX < 0) {
						tempX += Params.world_width;
					}
					break;
				case 5:
					tempX = this.x_coord - 1;
					if (tempX < 0) {
						tempX += Params.world_width;
					}
					tempY = (this.y_coord + 1) % Params.world_height;
					break;
				case 6:
					tempY = (this.y_coord + 1) % Params.world_height;
					break;
				case 7:
					tempX = (this.x_coord + 1) % Params.world_width;
					tempY = (this.y_coord + 1) % Params.world_height;
					break;
				}
				for (Critter critter : population){
					if ((critter.x_coord == tempX) && (critter.y_coord == tempY)){
						canMove = false;
					}
				}
			}
			if (canMove) {
				switch (direction) {
				case 0:
					this.x_coord = (this.x_coord + 1) % Params.world_width;
					break;
				case 1:
					this.x_coord = (this.x_coord + 1) % Params.world_width;
					this.y_coord -= 1;
					if (this.y_coord < 0) {
						this.y_coord += Params.world_height;
					}
					break;
				case 2:
					this.y_coord -= 1;
					if (this.y_coord < 0) {
						this.y_coord += Params.world_height;
					}
					break;
				case 3:
					this.x_coord -= 1;
					if (this.x_coord < 0) {
						this.x_coord += Params.world_width;
					}
					this.y_coord -= 1;
					if (this.y_coord < 0) {
						this.y_coord += Params.world_height;
					}
					break;
				case 4:
					this.x_coord -= 1;
					if (this.x_coord < 0) {
						this.x_coord += Params.world_width;
					}
					break;
				case 5:
					this.x_coord -= 1;
					if (this.x_coord < 0) {
						this.x_coord += Params.world_width;
					}
					this.y_coord = (this.y_coord + 1) % Params.world_height;
					break;
				case 6:
					this.y_coord = (this.y_coord + 1) % Params.world_height;
					break;
				case 7:
					this.x_coord = (this.x_coord + 1) % Params.world_width;
					this.y_coord = (this.y_coord + 1) % Params.world_height;
					break;
				}
				this.hasMoved = true;
			}
		}
		this.energy -= Params.walk_energy_cost;
	}
	
	/**
	 * The critter that calls this function moves two spaces in a specified direction and subtracts the appropriate amount of energy.
	 * 
	 * @param direction the direction that critter will move in
	 */
	protected final void run(int direction) {
		int tempX = -1;
		int tempY = -1;
		boolean canMove = true;
		if(!this.hasMoved){
			if (this.inFight) {
				switch (direction) {
				case 0:
					tempX = (this.x_coord + 2) % Params.world_width;
					break;
				case 1:
					tempX = (this.x_coord + 2) % Params.world_width;
					tempY = this.y_coord - 2;
					if (tempY < 0) {
						tempY += Params.world_height;
					}
					break;
				case 2:
					tempY = this.y_coord - 2;
					if (tempY < 0) {
						tempY += Params.world_height;
					}
					break;
				case 3:
					tempX = this.x_coord - 2;
					if (tempX < 0) {
						tempX += Params.world_width;
					}
					tempY = this.y_coord - 2;
					if (tempY < 0) {
						tempY += Params.world_height;
					}
					break;
				case 4:
					tempX = this.x_coord - 2;
					if (tempX < 0) {
						tempX += Params.world_width;
					}
					break;
				case 5:
					tempX = this.x_coord - 2;
					if (tempX < 0) {
						tempX += Params.world_width;
					}
					tempY = (this.y_coord + 2) % Params.world_height;
					break;
				case 6:
					tempY = (this.y_coord + 2) % Params.world_height;
					break;
				case 7:
					tempX = (this.x_coord + 2) % Params.world_width;
					tempY = (this.y_coord + 2) % Params.world_height;
					break;
				}
				for (Critter critter : population){
					if ((critter.x_coord == tempX) && (critter.y_coord == tempY)){
						canMove = false;
					}
				}
			}
			if (canMove) {
				switch (direction) {
				case 0:
					this.x_coord = (this.x_coord + 2) % Params.world_width;
					break;
				case 1:
					this.x_coord = (this.x_coord + 2) % Params.world_width;
					this.y_coord -= 2;
					if (this.y_coord < 0) {
						this.y_coord += Params.world_height;
					}
					break;
				case 2:
					this.y_coord -= 2;
					if (this.y_coord < 0) {
						this.y_coord += Params.world_height;
					}
					break;
				case 3:
					this.x_coord -= 2;
					if (this.x_coord < 0) {
						this.x_coord += Params.world_width;
					}
					this.y_coord -= 2;
					if (this.y_coord < 0) {
						this.y_coord += Params.world_height;
					}
					break;
				case 4:
					this.x_coord -= 2;
					if (this.x_coord < 0) {
						this.x_coord += Params.world_width;
					}
					break;
				case 5:
					this.x_coord -= 2;
					if (this.x_coord < 0) {
						this.x_coord += Params.world_width;
					}
					this.y_coord = (this.y_coord + 2) % Params.world_height;
					break;
				case 6:
					this.y_coord = (this.y_coord + 2) % Params.world_height;
					break;
				case 7:
					this.x_coord = (this.x_coord + 2) % Params.world_width;
					this.y_coord = (this.y_coord + 2) % Params.world_height;
					break;
				}
				this.hasMoved = true;
			}
		}
		this.energy -= Params.run_energy_cost;
	}
	
	/**
	 * This function performs all necessary instantiations on the offspring that has been created.
	 * 
	 * @param offspring The offspring critter object to be instantiated.
	 * @param direction The direction that the new offspring will be placed in relative to the parent.
	 */
	protected final void reproduce(Critter offspring, int direction) {
		if (this.energy < Params.min_reproduce_energy){
			return;
		}
		offspring.energy = this.energy/2;
		this.energy = (this.energy % 2) + (this.energy / 2);
		switch(direction){
			case 0:
				offspring.x_coord = (this.x_coord + 1) % Params.world_width;
				break;
			case 1:
				offspring.x_coord = (this.x_coord + 1) % Params.world_width;
				offspring.y_coord = this.y_coord - 1;
				if(offspring.y_coord < 0){
					offspring.y_coord += Params.world_height;
				}
				break;
			case 2:
				offspring.y_coord = this.y_coord - 1;
				if(offspring.y_coord < 0){
					offspring.y_coord += Params.world_height;
				}
				break;
			case 3:
				offspring.x_coord = this.x_coord - 1;
				if(offspring.x_coord < 0){
					offspring.x_coord += Params.world_width;
				}
				offspring.y_coord = this.y_coord - 1;
				if(offspring.y_coord < 0){
					offspring.y_coord += Params.world_height;
				}
				break;
			case 4:
				offspring.x_coord = this.x_coord - 1;
				if(offspring.x_coord < 0){
					offspring.x_coord += Params.world_width;
				}
				break;
			case 5:
				offspring.x_coord = this.x_coord - 1;
				if(offspring.x_coord < 0){
					offspring.x_coord += Params.world_width;
				}
				offspring.y_coord = (this.y_coord + 1) % Params.world_height;
				break;
			case 6:
				offspring.y_coord = (this.y_coord + 1) % Params.world_height;
				break;
			case 7:
				offspring.x_coord = (this.x_coord + 1) % Params.world_width;
				offspring.y_coord = (this.y_coord + 1) % Params.world_height;
				break;
		}
		babies.add(offspring);
	}

	public abstract void doTimeStep();
	public abstract boolean fight(String oponent);
	
	/**
	 * create and initialize a Critter subclass.
	 * critter_class_name must be the unqualified name of a concrete subclass of Critter, if not,
	 * an InvalidCritterException must be thrown.
	 * (Java weirdness: Exception throwing does not work properly if the parameter has lower-case instead of
	 * upper. For example, if craig is supplied instead of Craig, an error is thrown instead of
	 * an Exception.)
	 * @param critter_class_name the name for the critter they want made
	 * @throws InvalidCritterException if not valid subclass of critter
	 */
	public static void makeCritter(String critter_class_name) throws InvalidCritterException{
		Class c;
		Object critter;
		try { 
            c  = Class.forName("assignment5." + critter_class_name); 
        } catch (ClassNotFoundException e) {
			throw new InvalidCritterException(critter_class_name);
        } 
		try {
			critter = c.newInstance();
		} catch (IllegalAccessException e){
			throw new InvalidCritterException(critter_class_name);
		} catch (InstantiationException e){
			throw new InvalidCritterException(critter_class_name);
		}
		if (!(critter instanceof Critter)){
			throw new InvalidCritterException(critter_class_name);
		}
		population.add((Critter)critter);
		((Critter)critter).energy = Params.start_energy;
		((Critter)critter).x_coord = Critter.getRandomInt(Params.world_width);
		((Critter)critter).y_coord = Critter.getRandomInt(Params.world_height);
	}
	
	/**
	 * Gets a list of critters of a specific type.
	 * @param critter_class_name What kind of Critter is to be listed.  Unqualified class name.
	 * @return List of Critters.
	 * @throws InvalidCritterException if not valid subclass of critter
	 */
	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException{
		List<Critter> result = new java.util.ArrayList<Critter>();
		Object critter;
		Class<?> c;
		Class<?> crit;
		try { 
			crit = Class.forName("assignment5.Critter");
			c  = Class.forName("assignment5." + critter_class_name); 
        } catch (ClassNotFoundException e) {
			throw new InvalidCritterException(critter_class_name);
        } 
		try {
			critter = c.newInstance();
		} catch (IllegalAccessException e){
			throw new InvalidCritterException(critter_class_name);
		} catch (InstantiationException e){
			throw new InvalidCritterException(critter_class_name);
		}
		if (!(critter instanceof Critter)){
			throw new InvalidCritterException(critter_class_name);
		}
		for(Critter crt : population){
			if (critter.getClass().isInstance(crt) ){
				result.add(crt);
			}
		}
		return result;
	}
	
	/**
	 * Prints out how many Critters of each type there are on the board.
	 * @param critters List of Critters.
	 */
	public static void runStats(List<Critter> critters) {
		System.out.print("" + critters.size() + " critters as follows -- ");
		java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
		for (Critter crit : critters) {
			String crit_string = crit.toString();
			Integer old_count = critter_count.get(crit_string);
			if (old_count == null) {
				critter_count.put(crit_string,  1);
			} else {
				critter_count.put(crit_string, old_count.intValue() + 1);
			}
		}
		String prefix = "";
		for (String s : critter_count.keySet()) {
			System.out.print(prefix + s + ":" + critter_count.get(s));
			prefix = ", ";
		}
		System.out.println();		
	}
	
	/* the TestCritter class allows some critters to "cheat". If you want to 
	 * create tests of your Critter model, you can create subclasses of this class
	 * and then use the setter functions contained here. 
	 * 
	 * NOTE: you must make sure that the setter functions work with your implementation
	 * of Critter. That means, if you're recording the positions of your critters
	 * using some sort of external grid or some other data structure in addition
	 * to the x_coord and y_coord functions, then you MUST update these setter functions
	 * so that they correctly update your grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}
		
		protected void setX_coord(int new_x_coord) {
			super.x_coord = new_x_coord;
		}
		
		protected void setY_coord(int new_y_coord) {
			super.y_coord = new_y_coord;
		}
		
		protected int getX_coord() {
			return super.x_coord;
		}
		
		protected int getY_coord() {
			return super.y_coord;
		}
		

		/*
		 * This method getPopulation has to be modified by you if you are not using the population
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.
		 */
		protected static List<Critter> getPopulation() {
			return population;
		}
		
		/*
		 * This method getBabies has to be modified by you if you are not using the babies
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.  Babies should be added to the general population 
		 * at either the beginning OR the end of every timestep.
		 */
		protected static List<Critter> getBabies() {
			return babies;
		}
	}

	/**
	 * Clear the world of all critters, dead and alive
	 */
	public static void clearWorld() {
		population.clear();
	}
	
	
	/**
	 * The function that does a world time step for the critter.
	 */
	public static void worldTimeStep(){
		
		for(Iterator<Critter> iterator = population.iterator(); iterator.hasNext();){
			Critter crt = iterator.next();
			crt.inFight = false;
			crt.hasMoved = false;
			crt.doTimeStep();
			crt.energy -= Params.rest_energy_cost;
			if(crt.energy <= 0){
				iterator.remove();
			}
		}
		//encounters
		for (Critter crt : population){
			crt.inFight = true;
		}
		ArrayList<Encounters> fights = new ArrayList<Encounters>();
		fights = findEncounters();
		for(Encounters current : fights){
			ArrayList<Critter> fighters = current.getFighters();
			while(fighters.size() >= 2){
				Critter a = fighters.get(0);
				Critter b = fighters.get(1);
				boolean willAFight = a.fight(b.toString());
				boolean willBFight = b.fight(a.toString());
				if ((a.x_coord == b.x_coord) && (a.y_coord == b.y_coord)){
					int diceA;
					int diceB;
					if(willAFight){
						diceA = Critter.getRandomInt(a.energy + 1);
					}
					else{
						diceA = 0;
					}
					if(willBFight){
						diceB = Critter.getRandomInt(b.energy + 1);
					}
					else{
						diceB = 0;
					}
					if(diceA < diceB){
						//B wins
						b.energy += (a.energy/2);
						population.remove(a);
						fighters.remove(a);
					}
					else{
						//A wins (rolled higher or even)
						a.energy += (b.energy/2);
						population.remove(b);
						fighters.remove(b);
					}
				}
				else {
					fighters.remove(a);
					fighters.remove(b);
				}
			}
		}
		
		for(Critter crt : babies){
			population.add(crt);
		}
		babies.clear();
		for(int i = 0; i < Params.refresh_algae_count; i++){
			try{
				Critter.makeCritter("Algae");
			}catch (Exception e){}
		}
	}
	
	/**
	 * Displays the board to the console.
	 */
	public static void displayWorld() {
		try {
			Display.grid.getChildren().clear();
			for (Critter crt : population) {
				addCritter(crt.viewFillColor(), crt.viewOutlineColor(), crt.viewShape(), crt.x_coord, crt.y_coord);
			}
			new Display();
		} catch (Exception e) {

		}
	}
	
	/**
	 * 
	 */
	private static void addCritter(javafx.scene.paint.Color fill, javafx.scene.paint.Color outline, CritterShape crtShape, int x, int y){
		Shape s = null;
		switch(crtShape.ordinal()) {
		case 0: s = new Circle((Critter.size)/2); break;
		case 1: s = new Rectangle(Critter.size, Critter.size); break;
		case 2: s = new Polygon();
		((Polygon) s).getPoints().addAll(new Double[]{
	            (double) (x-(size/2)), (double) (y-(size/2)),
	            (double) (x-(size/2)), (double) (y+(size/2)),
	            (double) (x+(size/2)), (double) (y+(size/2)) });
		break;
		case 3: s = new Polygon(); 
		((Polygon) s).getPoints().addAll(new Double[]{
	            (double) (x-(size/2)), (double) y,
	            (double) x, (double) (y+(size/2)),
	            (double) (x+(size/2)), (double) y,
	            (double) x, (double) (y-(size/2))});
		break;
		case 4: s = new Polygon(); 
		((Polygon) s).getPoints().addAll(new Double[]{
				(double) (x-(size/6)), (double) (y-(size/6)),
				(double) (x-(size/2)), (double) (y-(size/6)),
				(double) (x-(size/4)), (double) (y+(size/6)),
	            (double) (x-(size/3)), (double) (y+(size/2)),
	            (double) x, (double) (y+(size/4)),
	            (double) (x+(size/3)), (double) (y+(size/2)),
	            (double) (x+(size/4)), (double) (y+(size/6)),
	            (double) (x+(size/2)), (double) (y-(size/6)),
	            (double) (x+(size/6)), (double) (y-(size/6)),
	            (double) x, (double) (y-(size/2))});
		break;
		}
		s.setFill(fill);
		s.setStroke(outline);
		Display.grid.add(s, x, y);
	}
	
	/**
	 * This function returns the arrayList of all the encounters that occur after a world time step.
	 * @return The list of all the encounters that happens each step.
	 */
	private static ArrayList<Encounters> findEncounters(){
		ArrayList<Encounters> encounters = new ArrayList<Encounters>();
		for(int i = 0; i < Params.world_width; i++){
			for(int j = 0; j < Params.world_height; j++){
				ArrayList<Critter> crts = new ArrayList<Critter>();
				for(Critter crt : population){
					if((crt.x_coord == i) && (crt.y_coord == j)){
						crts.add(crt);
					}
				}
				if(crts.size() > 1){
					Encounters current = new Encounters(i, j, crts);
					encounters.add(current);
				}
			}
		}
		return encounters;
	}
}
