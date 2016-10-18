package assignment4;

public class Reverse extends Critter{

	private int dir;
	private int doSwitch;
	
	@Override
	public String toString() {
		return "R";
	}
	
	public Reverse(){
		dir = Critter.getRandomInt(8);
	}
	
	@Override
	public void doTimeStep() {
		if(this.getEnergy() > 100){
			Reverse child = new Reverse();
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
