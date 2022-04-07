package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {

  /**
   * Adds element to the queue. The element will be the tail of the queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  public void offer(Integer x) {
    super.offer(x);
  }

  public void push(Integer x) {
    addRight(x);
  }

  public Integer pop() {
    return pollRight();
  }

  public Integer peek() {
    return peekRight();
  }

  public Integer poll() {
    return pollRight();
  }
}
