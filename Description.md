# FishTank
 *This project is the alternation of the Fish Tank Project in COMP SCI300 of UW-Madison (Fall 2021)*
 
 *import *core.jar* for visulization*
 
## goal

- Show a picture in the screen with moving fishes and decorations
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
	head
	tail
	size

##### Method
        - getHead
        - getTail
        - getSize
        - isEmpty
        - toString
			- mutator
        - setHead
        - setTail
        - addNode
          - add a new node at the end of the list
        - removeNode
          - remvoe the node with specifit data
- FishTankObject
	- The basic of decorations and fishes
		- Fields 
			- 	x & y position
			- 	image
		- Method
			- accessor
        - getPositions
        - setPositions
        - getImage
        - isMouseOver
        - toString
			- mutator
        - draw
        - move
        - mousePressed
        - mouseReleased 		
- FishTank extends PApplet  (with main mathod)
	- set up the basic for the processing the program
		- Fields
			- backgroundImage
			- decorations
			- fishes
			- randGen
				- a Random object
		- Methods
			- setting
			- setup
			- draw
			- mousePressed
				- if the mouse is over the fish, remove the fish or the fish will accelerate. 
				- if the fish accelarate, it will back to original speed when move out of the screen.
			- mouseReleased
				- if the number of fish is less than eight, add a new random fish
			- addFish
			  - Add random kinds of fish with random position and speed( 0< speed < 6)
			- main
- Fish extends TankObject
	- The fish can move from left to right	
	- Fields
		- speed
		- isSwimming
		- isAccelerated
	- Methods
		- get speed
		- draw
		- swim
		- accelerate
		- Decelerate
- BlueFish extends Fish
	- The blue fish should move from right to left
	- method
		- swim (override)
			- set the fish move from right to left



