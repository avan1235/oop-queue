package pl.edu.mimuw.queue;

public class IntQueueNode {
	private final Integer value;
	private IntQueueNode next;
	private IntQueueNode prev;
	
	public IntQueueNode(Integer value, IntQueueNode next, IntQueueNode prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	
	public IntQueueNode(Integer value) {
		this(value, null, null);
	}
	
	public int getValue() {
		return this.value;
	}
	
	public IntQueueNode getNext() {
		return this.next;
	}
	
	public IntQueueNode getPrev() {
		return this.prev;
	}
	
	public void setNext(IntQueueNode next) {
		this.next = next;
	}
	
	public void setPrev(IntQueueNode prev) {
		this.prev = prev;
	}
}
