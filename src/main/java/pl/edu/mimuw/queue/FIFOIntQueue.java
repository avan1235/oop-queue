package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {

  private IntQueueNode tail;

  public FIFOIntQueue() {
    super();
    this.tail = null;
  }

  /**
   * Adds the given value after the current tail of the queue.
   *
   * @param x the value to add
   * @throws NullPointerException if the given value is null
   */
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

  public Integer poll() {
    if (this.size() == 0) {
      return null;
    }

    final var value = this.head.getValue();
    this.head = this.head.getNext();

    if (this.head != null) {
      this.head.setPrev(null);
    } else {
      this.tail = null;
    }

    return value;
  }

  @Override
  public String toString() {
    final var sb = new StringBuilder();

    sb.append("FIFO ").append(super.toString());

    return sb.toString();
  }
}
