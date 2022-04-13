package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue {

  protected int size;
  protected IntQueueNode head;

  public AbstractIntQueue() {
    this.size = 0;
  }

  public abstract void offer(Integer x);

  public Integer peek() {
    if (size > 0) {
      return this.head.GetValue();
    } else {
      return null;
    }
  }

  public abstract Integer poll();

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Queue size: ")
      .append(this.size)
      .append("\n")
      .append("Queue order:")
      .append("\n");

    IntQueueNode copy = this.head;
    while(copy != null){
      result.append(copy.GetValue());
      copy = copy.GetNext();
      if(copy != null){
        result.append("; ");
      }else{
        result.append("\n");
      }
    }
    return result.toString();
  }

  public int size() {
    return this.size;
  }
}
