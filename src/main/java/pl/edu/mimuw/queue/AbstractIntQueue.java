package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {

  /**
   * Points to the front of the queue
   */
  protected IntQueueNode start = null;
  /**
   * Points to the end of the queue
   */
  protected IntQueueNode end = null;
  protected int size = 0;

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
  public abstract Integer peek();

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
  public abstract int size();
}
