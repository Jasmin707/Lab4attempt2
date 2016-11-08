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
