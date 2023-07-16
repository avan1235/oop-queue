package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {
	private int size;
	private IntQueueNode left, right;
	
	public AbstractIntQueue() {
		this.size = 0;
		this.left = this.right = null;
	}
	
	protected Integer front() {
		if(this.size == 0) {
			return null;
		}
		
		return this.left.getValue();
	}
	
	protected Integer back() {
		if(this.size == 0) {
			return null;
		}
		
		return this.right.getValue();
	}
	
	protected Integer popFront() {
		if(this.size == 0) {
			return null;
		}
		
		final var answer = this.left.getValue();
		this.left = this.left.getNext();
		
		if(--this.size == 0) {
			this.right = null;
		}
		
		return answer;
	}
	
	protected Integer popBack() {
		if(this.size == 0) {
			return null;
		}
		
		final var answer = this.right.getValue();
		this.right = this.right.getPrev();
		
		if(--this.size == 0) {
			this.left = null;
		}
		
		return answer;
	}
	
	protected void pushFront(Integer value) {
		if(value == null) {
			throw new NullPointerException("Null elements can't be added.");
		}
		
		if(this.size == 0) {
			this.left = new IntQueueNode(value);
			this.right = left;
		}
		else {
			this.left.setPrev(new IntQueueNode(value));
			this.left.getPrev().setNext(this.left);
			this.left = this.left.getPrev();
		}
		
		this.size++;
	}
	
	protected void pushBack(Integer value) {
		if(value == null) {
			throw new NullPointerException("Null elements can't be added.");
		}
		
		if(this.size == 0) {
			this.left = new IntQueueNode(value);
			this.right = this.left;
		}
		else {
			this.right.setNext(new IntQueueNode(value));
			this.right.getNext().setPrev(this.right);
			this.right = this.right.getNext();
		}
		
		this.size++;
	}
	
	public void clear() {
		while(this.size > 0) {
			this.popBack();
		}
	}
	
	/**
	 * Adds element to the queue.
	 *
	 * @throws NullPointerException if the specified element is null
	 */
	public abstract void offer(Integer value);
	
	/**
	 * @return the head of this queue, or {@code null} if this queue is empty
	 * and don't remove the element from the queue
	 */
	public abstract Integer peek();
	
	/**
	 * @return the head of this queue, or {@code null} if this queue is empty
	 * and remove the element from the queue
	 */
	public abstract Integer poll();
	
	/**
	 * @return readable representation of ordered queue elements
	 */
	@Override
	public String toString() {
		var answer = new StringBuilder()
		                 .append("size: ")
		                 .append(this.size())
		                 .append("\nelements: [");
		
		IntQueueNode curr = this.left;
		while(curr != null) {
			answer.append(curr.getValue());
			curr = curr.getNext();
			if(curr != null) {
				answer.append(", ");
			}
		}
		answer.append("]\n");
		
		return answer.toString();
	}
	
	/**
	 * @return the number of elements in this queue
	 */
	public int size() {
		return this.size;
	}
}
