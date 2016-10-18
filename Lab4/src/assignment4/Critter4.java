package assignment4;

public class Critter4 extends Critter{

	private int dir;
	private int doSwitch;
	
	/**
	 * returns string representation of the critter
	 */
	@Override
	public String toString() {
		return "R";
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

}
