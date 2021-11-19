
public class BlueFish extends Fish{

	
	// constructor
	/**
	 * build up a blue fish object with known position
	 * 
	 * @param x             the x-position of the fish
	 * @param y             the y=position of the fish
	 * @param speed         the speed of the fish
	 * @param imageFileName the file name of the fish
	 */
	public BlueFish(float x, float y, int speed) {
		super(x, y, speed, "images/blue.png");
	}

	/**
	 * build up a blue fish object with random position
	 * 
	 * @param speed         the speed of the fish
	 * @param imageFileName the file name of the fish
	 */
	public BlueFish(int speed) {
		super(speed, "images/blue.png");
	}
	
	/**
	 * move the blue fish object
	 */
	@Override
	public void swim() {
		// if the fish is accelerated and is moving out of the screen
		if (super.isAccelerate() && super.getX() - super.getSpeed() <= 0) {
			super.decelerate();
		}
		
		// avoid the x-position of the fish excess the screen
		float x = super.getX() - super.getSpeed();
		if( x < 0 ) {
			x = tank.width - ( 0 - x);
		}
		super.setX( x );
		super.setY(super.getY());
	}

}
