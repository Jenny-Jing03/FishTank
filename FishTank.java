import java.io.File;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class FishTank extends PApplet {

	// fields
	private PImage backgroundImage; // PImage object which represents the background image
	protected ObjectList decorations; // list of decorations
	protected ObjectList fishes; // the list of fishes
	protected Random randGen; // Generator of random numbers

	/**
	 * sets the size of this PApplet to 800 width x 600 height
	 */
	@Override
	public void settings() {
		size(800, 600);
	}

	/**
	 * Defines initial environment properties such as screen size and loads the
	 * background image and fonts as the program starts. It also initializes all
	 * data fields.
	 */
	@Override
	public void setup() {

		this.getSurface().setTitle("Fish Tank"); // Set and display the title of the display window

		this.imageMode(PApplet.CENTER); // Set the location from which images are drawn to CENTER

		this.rectMode(PApplet.CORNERS); // Set the location from which rectangles are drawn.

		this.focused = true; // Confirms that our Processing program is focused, meaning that it is active
								// and will accept mouse or keyboard input.

		this.textAlign(PApplet.CENTER, PApplet.CENTER); // sets the text alignment to center

		this.backgroundImage = this.loadImage("images/background.png"); // load the background image and store the
																		// loaded image to backgroundImage

		this.randGen = new Random(); // set randGen to the reference of a new Random objects

		TankObject.setProcessing(this);

		// build up the decorations
		TankObject flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
		TankObject log = new TankObject(580, 470, "images" + File.separator + "log.png");
		TankObject shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
		TankObject ship = new TankObject(280, 535, "images" + File.separator + "ship.png");
		// add the decorations into linked list
		decorations = new ObjectList();
		decorations.addNode(flower);
		decorations.addNode(log);
		decorations.addNode(shell);
		decorations.addNode(ship);

		// add eight random fishes to the tank
		fishes = new ObjectList();
		while (this.fishes.getSize() <= 5) {
			this.addFish();
		}

	}

	/**
	 * Continuously draws and updates the application display window
	 */
	@Override
	public void draw() {
		// clear the display window by drawing the background image
		this.image(backgroundImage, this.width / 2, this.height / 2);

		// draw the decoration
		LinkedNode<TankObject> temp = this.decorations.getHead();
		while (temp != null) {
			temp.getData().draw();
			temp = temp.getNext();
		}

		// draw the fishes
		temp = this.fishes.getHead();
		while (temp != null) {
			temp.getData().draw();
			temp = temp.getNext();
		}

	}

	/**
	 * Callback method called each time the user presses the mouse
	 */
	@Override
	public void mousePressed() {
		// if the mouse is over the fish, remove the fish
		LinkedNode<TankObject> temp = this.fishes.getHead();
		int index = 0;
		while (temp != null && index < fishes.getSize()) {
			if (temp.getData().isMouseOver()) {
				// remove the fish
				if (this.randGen.nextInt(100) % 2 == 0) {
					fishes.removeNode(index);
				}
				// fish accelerate
				else {
					if (temp.getData().getClass() == Fish.class || temp.getData().getClass() == BlueFish.class) {
						((Fish) temp.getData()).accelerate();
					}
				}
			}
			index++;
			temp = temp.getNext();
		}

	}

	/**
	 * Callback method called each time the mouse is released
	 */
	@Override
	public void mouseReleased() {
		// if the size of fishes is less than five, add a new random fish
		if (fishes.getSize() < 5) {
			this.addFish(0, this.randGen.nextFloat() * this.height);
		}
	}

	/**
	 * add a random color fish with specific position into the screen
	 */
	public void addFish(float x, float y) {

		while (fishes.getSize() <= 5) {
			int num = this.randGen.nextInt(4);
			int speed = this.randGen.nextInt(4) + 1;
			Fish newFish;
			if (num == 0) {
				// add an orange fish at random position
				newFish = new Fish(x, y, speed, "images/orange.png");
			} else if (num == 1) {
				// add a black fish at random position
				newFish = new Fish(x, y, speed, "images/black.png");
			} else if (num == 2) {
				// add a yellow fish at random position
				newFish = new Fish(x, y, speed, "images/yellow.png");
			} else {
				// add a blue fish at random position
				newFish = new BlueFish(this.width, y, speed);
			}

			// add the fish into list
			fishes.addNode(newFish);
		}
	}

	/**
	 * add a random color fish with random position into the screen
	 */
	public void addFish() {

		while (fishes.getSize() <= 5) {
			int num = this.randGen.nextInt(4);
			int speed = this.randGen.nextInt(4) + 1;
			Fish newFish;
			if (num == 0) {
				// add an orange fish at random position
				newFish = new Fish(speed, "images/orange.png");
			} else if (num == 1) {
				// add a black fish at random position
				newFish = new Fish(speed, "images/black.png");
			} else if (num == 2) {
				// add a yellow fish at random position
				newFish = new Fish(speed, "images/yellow.png");
			} else {
				// add a blue fish at random position
				newFish = new BlueFish(speed);
			}

			// add the fish into list
			fishes.addNode(newFish);
		}
	}

	public static void main(String[] args) {
		PApplet.main("FishTank");
	}
}
