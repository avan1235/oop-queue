package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {
  protected IntQueueNode front;
  protected IntQueueNode rear;
  protected int size;
  protected int maxCapacity;

  public AbstractIntQueue(int firstVal) {
    this();
    this.rear = this.front = new IntQueueNode(firstVal, null, null);
  }

  public AbstractIntQueue(int firstVal, int maxCapacity) {
    this(firstVal);
    this.maxCapacity = maxCapacity;
  }

  public AbstractIntQueue() {
    this.maxCapacity = Integer.MAX_VALUE;
  }

  public void offer(Integer x)//abstrakcja dodania peirwszego elementu kolejki wspólnego dla oobu rodzajów
  {
    this.rear = this.front = new IntQueueNode(x, null, null);
    this.size = 1;
  }

  public Integer peek() {
    if (this.front == null) return null;
    return this.front.getValue();
  }

  public Integer poll() {
    if (this.front == null) return null;
    Integer res = this.front.getValue();
    this.front = this.front.getNext();
    this.size--;
    return res;
  }

  public IntQueueNode getFront() {
    return this.front;
  }

  public IntQueueNode getRear() {
    return this.rear;
  }

  @Override
  public String toString()//abstrakcja wspólnej części budowy stringa dla obu (drukwoania samej listy)
  {
    var sb = new StringBuilder();
    var tempNode = this.front;
    while (tempNode != null) {
      sb.append(tempNode.getValue());
      tempNode = tempNode.getNext();
    }
    return sb.toString();
  }

  public int size() {
    return this.size;
  }

  public boolean empty() {
    return this.size == 0;
  }
}
