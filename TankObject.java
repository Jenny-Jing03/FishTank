import processing.core.PImage;

public class TankObject {

	// field
	protected static FishTank tank; // PApplet object which represents the display window

	protected PImage image; // image of this tank object

	private float x; // x-position of this tank in the display window
	private float y; // y-position of this tank in the display window
	
	protected String fileName; // the file name of the image

	/**
	 * @param x             the x-position of the object
	 * @param y             the y-position of the object
	 * @param imageFileName the file name of the object
	 */
	public TankObject(float x, float y, String imageFileName) {

		this.x = x;
		this.y = y;

		this.fileName = imageFileName;
		this.image = tank.loadImage(imageFileName);

	}
	
	/**
	 * Sets the PApplet graphic display window for all TankObjects
	 * 
	 * @param tank
	 */
	public static void setProcessing(FishTank tank) {
		TankObject.tank = tank;
	}

	/**
	 * Moves this tank object with dx and dy
	 * 
	 * @param dx move to the x-position of this tank object
	 * @param dy move to the y-position of this tank object
	 */
	public void move(int dx, int dy) {
		this.x += dx;
		this.x = this.x % tank.width;

		this.y += dy;
	}

	/**
	 * @return the x-position of this tank object
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * @return the y-position of this tank object
	 */
	public float getY() {
		return this.y;
	}
	
	/**
	 * @return the file Name of this tank object
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Sets the x-position of this object
	 * 
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Sets the y-position of this object
	 * 
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * @return the image of this tank object
	 */
	public PImage getImage() {
		return this.image;
	}
	
	/**
	 * draws this tank object to the display window
	 */
	public void draw() {
		tank.image(this.image, this.x, this.y);
	}
	

	/**
	 * checks if the mouse is over a specific object whose reference is provided as
	 * input parameter
	 * 
	 * @return true if the mouse is over the specific object object (i.e. over the
	 *         image of the object), false otherwise
	 */
	public boolean isMouseOver() {

		int obj_width = this.image.width; // get the width of fish picture
		int obj_hight = this.image.height; // get the high of fish picture

		// whether the X-position of mouse is over the fish
		if ((tank.mouseX < this.x - obj_width / 2) || (tank.mouseX > this.x + obj_width / 2)) {
			return false;
		}

		// whether the Y-position of mouse is over the fish
		if ((tank.mouseY < this.y - obj_hight / 2) || (tank.mouseY > this.y + obj_hight / 2)) {
			return false;
		}

		return true;
	}
	
	/**
	 * @return the information of the tank object
	 */
	@Override
	public String toString() {
		return this.fileName + " " + this.x + " " + this.y;
	}
	
}
