package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {

  private IntQueueNode tail;

  public FIFOIntQueue() {
    super();
    this.tail = null;
  }

  /**
   * Adds element to the end of the queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();
    IntQueueNode tmp = new IntQueueNode(x, null, this.tail);
    if (this.length == 0) {
      this.head = this.tail = tmp;
    } else {
      this.tail = this.tail.next = tmp;
    }
    this.length++;
  }

  public String toString() {
    return "FIFO queue: " + super.toString();
  }


}
