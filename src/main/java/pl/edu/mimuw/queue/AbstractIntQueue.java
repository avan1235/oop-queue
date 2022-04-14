package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {
  protected int length;
  protected IntQueueNode firstNode;
  // TODO: you can make changes with this class fields, constructors
  //  but also add some methods but the specified methods cannot be changed (you
  //  can change them not to be abstract and provide some implementation for them,
  //  but they have to have the same names, arguments and returned values)

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
    if(this.length != 0) {
      return this.firstNode.getValue();
    }
    return null;
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
    IntQueueNode i = this.firstNode;
    String result = "";
    while(i != null) {
      result += i.getValue() + " ";
      i = i.getNext();
    }
    return result;
  }

  /**
   * @return the number of elements in this queue
   */
  public int size() {
    return this.length;
  }
}
