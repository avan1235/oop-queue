package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {

  protected IntQueueNode head;

  protected AbstractIntQueue() {
    head = null;
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
    if (this.size() == 0) {
      return null;
    }

    return this.head.getValue();
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
    final var sb = new StringBuilder();

    sb.append("queue: [");
    for (IntQueueNode node = head; node != null; node = node.getNext()) {
      sb.append(node.getValue());
      if (node.getNext() != null) {
        sb.append(", ");
      }
    }
    sb.append("]");

    return sb.toString();
  }

  /**
   * @return the number of elements in this queue
   */
  public int size() {
    int size = 0;

    for (IntQueueNode node = head; node != null; node = node.getNext()) {
      size++;
    }

    return size;
  }
}
