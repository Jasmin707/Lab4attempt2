package assignment4;

public class Jasmin extends Critter{

	private int dir;
	
	@Override
	public String toString() { return "J"; }
	
	public Jasmin(){
		dir = Critter.getRandomInt(8);
		
	}
	
	@Override
	public void doTimeStep() {
		 if (this.getEnergy() > 180){
			 Jasmin child = new Jasmin();
			 reproduce(child, Critter.getRandomInt(8));
		 }
		 else{
			 walk((dir + 1) % 8);
		 }
		
	}

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
