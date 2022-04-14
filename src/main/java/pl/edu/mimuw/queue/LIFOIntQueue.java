package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {

  public LIFOIntQueue(int firstVal, int maxCapacity) {
    super(firstVal, maxCapacity);
  }

  public LIFOIntQueue(int firstVal) {
    super(firstVal);
  }

  public LIFOIntQueue() {
    super();
  }

  @Override
  public void offer(Integer x) {
    if (this.size == 0) super.offer(x);//wykorzystanie wspólnego działania dla przypadku dodawania pierwszego elementu
    else if (this.size < this.maxCapacity) {
      var newNode = new IntQueueNode(x, null, this.rear);
      this.rear.setNext(newNode);
      this.rear = newNode;
      this.size++;
    }
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    if (this.size == 0) sb.append("Queue type: LIFO, queue empty");
    else {
      sb.append("Queue type: LIFO,").append("queue size: ").append(this.size).append(" values: ").append(super.toString());//wykorzystanie abstrakcji toString() wartości na liście
    }
    return sb.toString();
  }
}
