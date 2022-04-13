package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {
	public void offer(Integer value) {
		super.pushFront(value);
	}
	
	public Integer peek() {
		return super.front();
	}
	
	public Integer poll() {
		return super.popFront();
	}
}
