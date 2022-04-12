package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {
  protected IntQueueNode begin;
  protected int size;
  AbstractIntQueue() {
    begin = null;
    size = 0;
  }
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
  public String toString() {
    StringBuilder str = new StringBuilder("LIFO queue, next elements: ");
    IntQueueNode act = begin;
    while (act != null) {
      str.append(act.value);
      str.append(", ");
      act = act.next;
    }
    return str.toString();
  }

  /**
   * @return the number of elements in this queue
   */

  public int size() {
    return size;
  }
}
