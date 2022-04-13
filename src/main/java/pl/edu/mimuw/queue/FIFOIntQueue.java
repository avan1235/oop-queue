package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {
	public void offer(Integer value) {
		super.pushBack(value);
	}
	
	public Integer peek() {
		return super.front();
	}
	
	public Integer poll() {
		return super.popFront();
	}
}
