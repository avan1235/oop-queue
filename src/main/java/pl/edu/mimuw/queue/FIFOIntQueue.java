package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {

  private IntQueueNode last;

  public FIFOIntQueue() {
    super();
    this.last = null;
  }

  @Override
  public void offer(Integer x) {
    this.size++;
    IntQueueNode newNode = new IntQueueNode(x);
    if (this.last == null) {
      assert (this.first == null);
      this.first = newNode;
    } else {
      newNode.setPrev(this.last);
      this.last.setNext(newNode);
    }
    this.last = newNode;
  }

  @Override
  public Integer poll() {
    if (this.first == null) {
      assert (this.last == null);
      return null;
    }
    this.size--;
    Integer output = this.first.getValue();
    if (this.first == this.last) {
      this.first = null;
      this.last = null;
    } else {
      this.first = this.first.getNext();
    }
    return output;
  }
}
