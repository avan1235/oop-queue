package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {
  public LIFOIntQueue() {
    super();
  }

  /**
   * Adds element to the front of the queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException("specified element is null");

    this.size++;
    this.front = new IntQueueNode(x, this.front);
  }

  public Integer poll() {
    if (this.peek() == null) return null;

    this.size--;
    final int value = this.front.GetValue();
    this.front = this.front.GetNext();
    return value;
  }
}
