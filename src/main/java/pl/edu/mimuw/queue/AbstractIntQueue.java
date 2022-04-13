package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {

  /**
   * front to zawsze reprezentacja elementu, ktory zostanie pierwszy zdjety z kolejki lub null gdy jest pusta
   */
  protected IntQueueNode front;
  protected int size;

  /**
   * Adds element to the queue.
   * @throws NullPointerException if the specified element is null
   */
  public abstract void offer(Integer x);  

  /**
   * @return the head of this queue, or {@code null} if this queue is empty
   * and don't remove the element from the queue
   */
  public Integer peek() {
    if (front == null) {
      return null;
    }
    else
    {
      return front.getValue();
    }
  }

  /**
   * @return the head of this queue, or {@code null} if this queue is empty
   * and remove the element from the queue
   */
  public Integer poll(){
    if (front == null) {
      return null;
    }
    else
    {
      IntQueueNode returned = front;
      front = front.getNext();
      size--;
      return returned.getValue();
    }
  }
  /**
   * @return readable representation of ordered queue elements
   */
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    IntQueueNode currentNode = front;
    sb.append("Queue contains: ");
    if(front == null){
      sb.append("NOTHING");
      return sb.toString();
    }
    while(currentNode != null){
      sb.append(currentNode.getValue()+" ");
      currentNode=currentNode.getNext();
    }
    return sb.toString(); 
  }

  /**
   * @return the number of elements in this queue
   */
  public int size() {
    return size;
  }
}
