# FishTank
 *This project is the alternation of the Fish Tank Project in COMP SCI300 of UW-Madison (Fall 2021)*
 *import *core.jar* for visulization*
## goal

- Show a picture in the screen with fish and decoration
- No more than 6 moving fishes appeared in the screen
- When clicking a fish, delete the fish, and add a new fish into screen 
- four types of fish with random speed will add randomly into the screen

**import *core.jar* for visulization** 

### component 

- Double Linked List
  - Fields
    - data
      - the data field
  	- front 
  		- the previous node
  	- next
  		- the next node
  - Method

      - accessor
        - getData
        - getFront
        - getNext
        - toString
      - mutator
          - 	 setFront
          - 	 setNext	
- ObjectList
	- store the decorations and fishes
		- FIelds
			- head
			- tail
			- size
		- Method
			- accessor
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



