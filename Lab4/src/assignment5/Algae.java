package assignment5;

import assignment5.Critter.TestCritter;

public class Algae extends TestCritter {

	@Override
	public String toString() { return "@"; }
	
	@Override
	public boolean fight(String opponent) {
		if (toString().equals(opponent)) { // same species as me!
			/* try to move away */
			walk(Critter.getRandomInt(8));
		}
		return false; 
	}
	
	@Override
	public void doTimeStep() {
		setEnergy(getEnergy() + Params.photosynthesis_energy_amount);
	}
	
	@Override
	public CritterShape viewShape() { return CritterShape.CIRCLE; }
	@Override
	public javafx.scene.paint.Color viewColor() { return javafx.scene.paint.Color.GREEN; }
}
