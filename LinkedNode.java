
public class LinkedNode<T> {

	// field
	private T data; // the data of the this linked node
	private LinkedNode<T> front; // the reference of the previous node
	private LinkedNode<T> next; // the reference of the next node

	// constructor
	/**
	 * @param data the data field
	 */
	public LinkedNode(T data) {
		this.data = data;
		this.front = null;
		this.next = null;
	}

	/**
	 * @param data  the data field
	 * @param front the previous node
	 */
	public LinkedNode(T data, LinkedNode<T> front) {
		this.data = data;
		this.front = front;
		this.next = null;
	}

	/**
	 * @param data  the data field
	 * @param front the previous node
	 * @param next  the next node
	 */
	public LinkedNode(T data, LinkedNode<T> front, LinkedNode<T> next) {
		this.data = data;
		this.front = front;
		this.next = next;
	}

	// accessor
	/**
	 * @return the data field
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * @return the previous node
	 */
	public LinkedNode<T> getFront() {
		return this.front;
	}

	/**
	 * @return the next node
	 */
	public LinkedNode<T> getNext() {
		return this.next;
	}
	
	/**
	 * @return the description of the data
	 */
	@Override
	public String toString() {
		return this.data.toString();
	}

	// mutator
	/**
	 * @param front the previous node
	 */
	public void setFront(LinkedNode<T> front) {
		this.front = front;
	}

	/**
	 * @param next the next node
	 */
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}

}
