
public class Fish extends TankObject {

	// fields
	private int speed; // the speed of the fish
	private boolean isSwimming; // whether the fish is moving
	private boolean isAccelerated; // whether the fish is accelerated

	// constructor
	/**
	 * build up a fish object with known position
	 * 
	 * @param x             the x-position of the fish
	 * @param y             the y=position of the fish
	 * @param speed         the speed of the fish
	 * @param imageFileName the file name of the fish
	 */
	public Fish(float x, float y, int speed, String imageFileName) {
		super(x, y, imageFileName);
		this.speed = speed;
		this.isSwimming = true;
		this.isAccelerated = false;
	}

	/**
	 * build up a fish object with random position
	 * 
	 * @param speed         the speed of the fish
	 * @param imageFileName the file name of the fish
	 */
	public Fish(int speed, String imageFileName) {
		super(tank.randGen.nextFloat() * tank.width, tank.randGen.nextFloat() * tank.height, imageFileName);
		this.speed = speed;
		this.isSwimming = true;
	}

	// accessor
	/**
	 * @return the speed of the fish
	 */
	public int getSpeed() {
		return this.speed;
	}
	
	/**
	 * @return whether the fish is accelerated
	 */
	public boolean isAccelerate() {
		return this.isAccelerated;
	}
	
	/**
	 * @return the information of the fish
	 */
	@Override
	public String toString() {
		return super.fileName + " " + super.getX() + " " + super.getY() +"  " + this.speed;
	}

	// mutator
	/**
	 * draw the fish object
	 */
	public void draw() {
		if (this.isSwimming) {
			this.swim();
		}
		super.draw();
	}

	/**
	 * move the fish object
	 */
	public void swim() {
		// if the fish is accelerated and is moving out of the screen
		if (this.isAccelerated && super.getX() + this.speed >= tank.width) {
			this.decelerate();
		}
		super.move(this.speed, 0);
	}

	/**
	 * add 5 to the speed of the fish
	 */
	public void accelerate() {
		this.isAccelerated = true;
		this.speed += 5;
	}

	/**
	 * change the speed of fish into origin
	 */
	public void decelerate() {
		this.isAccelerated = false;
		this.speed -= 5;
	}

}
