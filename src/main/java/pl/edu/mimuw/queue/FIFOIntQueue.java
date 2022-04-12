package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {

  public FIFOIntQueue() {
    this.queue = null;
    this.size = 0;
  }

  public FIFOIntQueue(int value) {
    this.queue = new IntQueueNode(value);
    this.size = 1;
  }

  /**
   * Adds element to the end of the queue. As a result, new element can be
   * polled only when all the previous queue elements have been polled.
   * Queue head thus remains unchanged.
   *
   * @throws NullPointerException if the specified element is null
   * @see AbstractIntQueue#poll()
   */
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();

    if (this.isEmpty())
      this.queue = new IntQueueNode(x);
    else
      this.queue.attachToEnd(new IntQueueNode(x));

    this.size++;
  }
}
