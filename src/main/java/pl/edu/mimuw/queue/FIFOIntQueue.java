package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {
  // TODO: make changes with this class fields, constructors, methods

  private IntQueueNode tail;

  public FIFOIntQueue() {
    super();
    this.tail = null;
  }

  public void offer(Integer x) {
    if (x == null) {
      throw new NullPointerException();
    }

    if (this.size() == 0) {
      this.head = new IntQueueNode(x);
      this.tail = this.head;
    } else {
      this.tail.setNext(new IntQueueNode(x, null, this.tail));
      this.tail = this.tail.getNext();
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

    final var x = this.head.getValue();
    this.head = this.head.getNext();

    if (this.head == null) {
      this.tail = null;
    }

    return x;
  }
}
