package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {
  int size;
  protected IntQueueNode front, back;

  /*
  In my implementation, front is more
  important, which means that if there is
  only one element, it's kept in the front
  of the queue

  This makes poll in LIFO implementation slightly
  more complicated, because when we have to pop
  element and we are left with one in the queue
  we have to clear the "back" of queue
  */

  public void push(Integer x) {
    if (x == null) {
      throw new NullPointerException("Can't add null elements");
    }
    this.size++;
    if (this.size == 1) {
      this.front = new IntQueueNode(x, null, null);
      this.back = null;
      return;
    }
    if (this.size == 2) {
      var newBack = new IntQueueNode(x, null, null);
      var newFront = this.front;
      newBack.setPrev(newFront);
      newFront.setNext(newBack);
      this.back = newBack;
      this.front = newFront;
      return;
    }
    var oldBack = this.back;
    var newBack = new IntQueueNode(x, null, oldBack);
    newBack.setPrev(oldBack);
    oldBack.setNext(newBack);
    this.back = newBack;
  }

  public abstract void offer(Integer x);

  public abstract Integer peek();

  public abstract Integer poll();

  @Override
  public String toString() {
    var sb = new StringBuilder();
    sb.append("Size of queue: ").append(this.size).append("\n");
    if (this.size == 0) {
      sb.append("Queue is empty!");
      return (sb.toString());
    }
    sb.append("Elements of queue:\n");
    IntQueueNode begin = this.front;
    int count = 0;
    while (begin != null) {
      sb.append(begin.getValue()).append(" ");
      begin = begin.getNext();
    }
    return sb.toString();
  }

  /**
   * @return the number of elements in this queue
   */
  public int size() {
    return this.size;
  }
}
