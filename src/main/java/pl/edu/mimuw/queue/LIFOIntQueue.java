package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {

  public LIFOIntQueue() {
    super();
  }

  /**
   * Adds element to the beginning of the queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();
    var tmp = new IntQueueNode(x, this.head, null);
    if (this.head != null) this.head.prev = tmp;
    this.head = tmp;
    this.length++;
  }


  public String toString() {
    return "LIFO queue: " + super.toString();
  }


}
