# FishTank
 *This project is the alternation of the Fish Tank Project in COMP SCI300 of UW-Madison (Fall 2021)*
 
 *import *core.jar* for visulization*
 
## goal

- Show a picture in the display window with moving fishes and decorations
- No more than 6 moving fishes appeared in the screen
- When clicking a fish, delete the fish, and add a new fish into screen 
- four types of fish with random speed will add randomly into the screen

### component 

#### LinkedNode Class
- This represents the generic abstract data type linked node. This interface will be implemented by a non-generic data structure double linked list in other class.

##### Fields
	data: the reference of data in this linked node
   	front: the reference of previous node
	next: the reference of next node
    
##### Method
	getData: get the data in this linked node
	getFront: get the reference of the previous node
	getNext: get the reference of the next node
	toString: return the string representation of the node
	setFront: set the reference of the previous node
	setNext: set the reference of the next node
	
#### ObjectList Class
- This represents the double linked list of TankObject for storing the decorations and fishes

##### Fields
	head: the reference of head in the double linked list
	tail: the reference of tail in the double linked list
	size: the size of the double linked list

##### Method
	getHead: get the head of this linked list
	getTail: get the tail of this linked list
	getSize: get the size of this linked list
	isEmpty: whether this double linked list is empty
	toString: get the description of the nodes in the linked list
	setHead: set the reference of the head of this linked list
	setTail: set the reference of the tail of this linked list
	addNode: add a new node at the end of the linked list
	removeNode: remvoe the node with valid index

#### FishTankObject Class
- This represents the objects that will appear in the FishTank

##### Fields 
	x: the x-position of this tank object
	y: the y-position of this tank object
	image: image of this tank object

##### Method
	setProcessing: set the PApplet graphic display window for all TankObjects
	getX: get the x-position of this tank object
	getY: get the y-position of this tank object
	setX: set the x-position of this tank object
	setY: set the y-position of this tank object
	getFileName: get the FileName of this tank object
	getImage: get the image of this tank object
	isMouseOver: whether ths mouse is over this tank object
	toString: get the information of the tank object (fileName and position)
	draw: draw this tank object to the display window
	move: Moves this tank object	
	
#### FishTank Class (with main mathod)
- extends PApplet
- set up the basic for the processing the program

##### Fields
	backgroundImage: PImage object which represents the background image
	decorations: a double linked list that store the decorations
	fishes: a double linked list that store the fishes
	randGen: a Random object

##### Methods
	setting: sets the size of this PApplet to 800 width x 600 height
	setup: define initial environment properties such as screen size and loads the background image and fonts as the program starts. It also initializes all data fields.
	draw: continuously draws and updates the application display window
	mousePressed: If the mouse is over the fish, remove the fish or the fish will accelerate. If the fish accelarate, it will back to original speed when move out of the screen.
	mouseReleased: If the number of fish is less than six, add a new random fish into the display window
	addFish: add random kinds of fish with random position and speed( 0< speed < 6)
	
#### Fish Class
- extends TankObject
- The fish can move from left to right	

##### Fields
	speed: the speed of this fish object
	isSwimming: whether this fish object is moving
	isAccelerated: whether this fish object is accelerating

##### Methods
	getSpeed: get the speed of this fish object
	draw: draw the fish object
	swim: move the fish object
	accelerate: add 5 to the speed of this fish object
	Decelerate: alther the speed of this fish into original speed
	toString: get the information of the tank object (fileName & position & speed)
	
#### BlueFish Class
- extends Fish
- The blue fish should move from right to left
##### Methods
	swim (override: set the fish move from right to left



