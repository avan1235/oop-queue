package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {
  private IntQueueNode lastNode;
  public FIFOIntQueue() {
    this.firstNode = null;
    this.lastNode = null;
    this.length = 0;
  }
  public Integer poll()  {
    if(this.length != 0) {
      Integer value;
      value = this.firstNode.getValue();
      this.firstNode = this.firstNode.getNext();
      this.firstNode.setPrev(null);
      this.length--;
      if(this.length == 0) {
        this.lastNode = null;
      }
      return value;
    }
    return null;
  }
  public void offer(Integer x) {
    if(x == null) throw new NullPointerException("Pushed value is null");
    this.length++;
    if(this.lastNode == null) {
      this.firstNode = new IntQueueNode(x);
      this.lastNode = this.firstNode;
    }
    else {
      IntQueueNode n = new IntQueueNode(x);
      n.setPrev(this.lastNode);
      this.lastNode.setNext(n);
      this.lastNode = n;
    }
  }
}
