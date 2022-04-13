package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {

  protected IntQueueNode head;
  protected int length;

  public AbstractIntQueue() {
    this.head = null;
    this.length = 0;
  }


  /**
   * @return number of elements of this queue
   */
  public int getLength() {
    return this.length;
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
    if (this.head == null) return null;
    return this.head.getValue();
  }

  /**
   * @return the head of this queue, or {@code null} if this queue is empty
   * and remove the element from the queue
   */
  public Integer poll() {
    if (this.head == null) return null;
    int tmp = this.head.getValue();
    this.head = this.head.next;
    if (this.head != null) this.head.prev = null;
    this.length--;
    return tmp;
  }

  /**
   * @return readable representation of ordered queue elements
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    IntQueueNode tmp = this.head;
    for (int i = 0; i < this.length; i++) {
      sb.append(tmp.getValue() + " ");
      tmp = tmp.next;
    }
    return sb.toString();
  }

  /**
   * @return the number of elements in this queue
   */
  public int size() {
    return this.length;
  }
}
