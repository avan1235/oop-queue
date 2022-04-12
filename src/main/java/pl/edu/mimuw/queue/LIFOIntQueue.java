package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {

  public LIFOIntQueue() {
    this.queue = null;
    this.size = 0;
  }

  public LIFOIntQueue(int value) {
    this.queue = new IntQueueNode(value);
    this.size = 1;
  }

  /**
   * Adds element as the first element of the queue and makes it a new
   * queue head. As a result, new element can be polled instantly. Previous
   * head is next in queue to be polled.
   *
   * @throws NullPointerException if the specified element is null
   * @see AbstractIntQueue#poll()
   */
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();

    if (this.isEmpty())
      this.queue = new IntQueueNode(x);
    else {
      this.queue.attachPrev(new IntQueueNode(x));
      this.queue = this.queue.prev();
    }

    this.size++;
  }
}
