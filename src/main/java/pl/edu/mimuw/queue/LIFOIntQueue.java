package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {

  public LIFOIntQueue() {
    super();
  }

  /**
   * Adds a new element before the current head of the queue.
   *
   * @param x element to be added
   * @throws NullPointerException if x is null
   */
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

  public Integer poll() {
    if (this.size() == 0) {
      return null;
    }

    final var value = this.head.getValue();
    this.head = this.head.getNext();
    this.head.setPrev(null);

    return value;
  }

  @Override
  public String toString() {
    final var sb = new StringBuilder();

    sb.append("LIFO ").append(super.toString());

    return sb.toString();
  }
}
