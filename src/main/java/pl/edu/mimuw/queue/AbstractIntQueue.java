package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {
  protected IntQueueNode front;
  protected int size;

  protected AbstractIntQueue() {
    this.size = 0;
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
  public Integer peek() {
    if (size == 0) return null;
    return this.front.GetValue();
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
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("queue: [");
    while (this.peek() != null) {
      stringBuilder.append(" " + this.poll());
    }
    stringBuilder.append(" ]");
    return stringBuilder.toString();
  }

  /**
   * @return the number of elements in this queue
   */
  public int size() {
    return this.size;
  }
}
