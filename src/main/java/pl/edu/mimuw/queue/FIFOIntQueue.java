package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {

  /**
   * Adds element to the queue. The element will be the head of the queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  public void offer(Integer x) {
    super.offer(x);
  }

  public Integer peek() {
    return peekLeft();
  }

  public Integer poll() {
    return pollLeft();
  }
}
