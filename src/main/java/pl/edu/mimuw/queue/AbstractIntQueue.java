package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {
  protected int size;
  protected IntQueueNode head;

  /**
   * Adds element to the queue.
   *
   * @throws NullPointerException if the specified element is null
   */
  public abstract void offer(Integer x);

  /**
   * @return the head of this queue, or {@code null} if this queue is empty
   * and don't remove the element from the queue
   */
  public Integer peek() {
    if (this.size == 0) {
      return null;
    } else {
      return this.head.getValue();
    }
  }

  /**
   * @return the head of this queue, or {@code null} if this queue is empty
   * and remove the element from the queue
   */
  public abstract Integer poll();

  /**
   * @return readable representation of ordered queue elements
   */
  @Override
  public abstract String toString();

  /**
   * @return the number of elements in this queue
   */
  public int size() {
    return this.size;
  }
}
