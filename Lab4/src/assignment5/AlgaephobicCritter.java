/* CRITTERS AlgaephoviCritter.java
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

//import project5.Critter.CritterShape;

public class AlgaephobicCritter extends Critter {

	@Override
	public String toString() { return "S"; }

	public AlgaephobicCritter() {
		Params.look_energy_cost = 0;
		Params.walk_energy_cost = 0;
		Params.run_energy_cost = 0;
		Params.refresh_algae_count = 0;
	}

	@Override
	public boolean fight(String not_used) { return false; }

	@Override
	public void doTimeStep() {
		/* Move to somewhere without algae */
		for (int dir = 0; dir < 8; dir++) {
			if(this.look(dir, false) == null) {
				walk(dir);
				return;
			}
		}			
		for (int dir = 0; dir < 8; dir++) {
			if(this.look(dir, true) == null) {
				run(dir);
				return;
			}
		}
		return;
	}

	public static String runStats(java.util.List<Critter> avoidingCritters) {
		String out = new String();
		if(avoidingCritters.size() != 0) {
			out = "So far so good";
		}
		else {
			out = "Algae suck";
		}
		return out;
	}

	@Override
	public CritterShape viewShape() { return CritterShape.TRIANGLE; }

	@Override
	public javafx.scene.paint.Color viewOutlineColor() { return javafx.scene.paint.Color.SALMON; }

}
