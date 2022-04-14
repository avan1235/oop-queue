package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {
  public LIFOIntQueue() {
    this.firstNode = null;
    this.length = 0;
  }
  public Integer poll()  {
    if(this.length != 0) {
      Integer value;
      value = this.firstNode.getValue();
      this.firstNode = this.firstNode.getNext();
      this.firstNode.setPrev(null);
      this.length--;
      return value;
    }
    return null;
  }
  public void offer(Integer x) {
    if(x == null) throw new NullPointerException("Pushed value is null");
    this.length++;
    if(this.firstNode == null) {
      this.firstNode = new IntQueueNode(x);
    }
    else {
      IntQueueNode n = new IntQueueNode(x);
      this.firstNode.setPrev(n);
      n.setNext(this.firstNode);
      this.firstNode = n;
    }
  }
}