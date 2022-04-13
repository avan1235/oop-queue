package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {
  // TODO: make changes with this class fields, constructors, methods

  public LIFOIntQueue() {
    super();
  }

  public void offer(Integer x) {
    if (x == null) {
      throw new NullPointerException();
    }

    if (this.size() == 0) {
      this.head = new IntQueueNode(x);
    } else {
      this.head.setPrev(new IntQueueNode(x, this.head, null));
      this.head = this.head.getPrev();
    }
  }

  public Integer peek() {
    if (this.size() == 0) {
      return null;
    }

    return this.head.getValue();
  }

  public Integer poll() {
    if (this.size() == 0) {
      return null;
    }

    Integer value = this.head.getValue();
    this.head = this.head.getNext();
    return value;
  }
}
