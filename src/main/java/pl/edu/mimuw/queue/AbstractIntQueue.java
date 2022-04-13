package pl.edu.mimuw.queue;

import java.util.ArrayList;


public abstract class AbstractIntQueue {

  protected int size;
  protected IntQueueNode first;

  public AbstractIntQueue() {
    this.first = null;
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
    if (this.first == null)
      return null;
    return this.first.getValue();
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
    IntQueueNode tempNode = this.first;
    StringBuilder output = new StringBuilder();
    while (tempNode != null) {
      output.append(" ").append(tempNode.getValue());
      tempNode = tempNode.getNext();
    }
    return output.toString();
  }

  /**
   * @return the number of elements in this queue
   */
  public Integer size() {
    return this.size;
  }
}
