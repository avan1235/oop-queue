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
   * Adds element to the queue based on the queue type.
   *
   * @throws NullPointerException if the specified element is null
   */
  public abstract void offer(Integer x);

  /**
   * @return the head of this queue, or {@code null} if this queue is empty
   * and don't remove the element from the queue
   */
  public Integer peek() {
    return this.start == null ? null : this.start.getValue();
  }

  /**
   * @return the head of this queue, or {@code null} if this queue is empty
   * and remove the element from the queue
   */
  public Integer poll() {
    if (this.start == null) {
      return null;
    }

    Integer returnValue = this.start.getValue();
    this.start = this.start.getNext();
    this.size--;
    if (this.size == 0) {
      this.end = null;
    }
    return returnValue;
  }

  /**
   * @return readable representation of queue based on the order of elements in queue
   */
  protected String stringQueueRepresentation() {
    var sb = new StringBuilder();
    sb.append("[");
    for (var element = this.start; element != null; element = element.getNext()) {
      sb.append(element.getValue());
      if (element.getNext() != null) {
        sb.append(", ");
      }
    }
    sb.append("]");

    return sb.toString();
  }

  /**
   * @return readable representation of ordered queue elements with specified queue type
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
