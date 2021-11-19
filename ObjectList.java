
public class ObjectList {

	// fields
	private LinkedNode<TankObject> head; // the reference of the head node 
	private LinkedNode<TankObject> tail; // the reference of the tail node
	private int size; // the size of the double linked list

	/**
	 * build up an empty objectList
	 */
	public ObjectList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// accessor
	/**
	 * @return the head of the list
	 */
	public LinkedNode<TankObject> getHead() {
		return this.head;
	}

	/**
	 * @return the tail of the list
	 */
	public LinkedNode<TankObject> getTail() {
		return this.tail;
	}

	/**
	 * @return the size of the list
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * @return true if the list is empty; else return false
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * @return the description of the nodes in the linked list
	 */
	public String toString() {
		String description = "";

		// get the information of each node in the list
		LinkedNode<TankObject> temp = this.head;
		while (temp != null) {
			description += temp.toString() + "\n";
			temp = temp.getNext();
		}
		return description;
	}

	// mutator
	/**
	 * @param head the head of the list
	 */
	public void setHead(LinkedNode<TankObject> head) {
		this.head = head;
	}

	/**
	 * @param tail the tail of the list
	 */
	public void setTail(LinkedNode<TankObject> tail) {
		this.tail = tail;
	}

	/**
	 * @param toAdd the node that need to add at the end of the list
	 */
	public void addNode(TankObject toAdd) {

		// build up the LinkedNode for toAdd
		LinkedNode<TankObject> add = new LinkedNode<TankObject>(toAdd);

		// if the list is empty
		if (this.isEmpty()) {
			this.head = add;
			this.tail = add;
		} else {
			// set the previous node of toAdd as the tail
			add.setFront(this.tail);
			// set the next node of the tail as toAdd
			this.tail.setNext(add);
			// set the toAdd as tail
			this.tail = add;
		}

		this.size++;
	}

	/**
	 * @param toRemove the valid index of the node that need to remove
	 */
	public void removeNode(int index) {

		LinkedNode<TankObject> temp = this.head;

		// remove the first fish
		if (index == 0) {
			this.head = temp.getNext();
			temp.getNext().setFront(null);
		}
		// remove the last fish
		else if (index == this.size - 1) {
			this.tail = this.tail.getFront();
			this.tail.setNext(null);
		} else {
			// reach the node at specific position
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			// delete the node
			temp.getFront().setNext(temp.getNext());
			temp.getNext().setFront(temp.getFront());
		}
		size--;
	}

}
