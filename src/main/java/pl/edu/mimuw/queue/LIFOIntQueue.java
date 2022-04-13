package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {
  public LIFOIntQueue() {

  }

  @Override
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();

    final IntQueueNode newN = new IntQueueNode(x);

    newN.SetNext(this.head);
    this.head = newN;

    this.size++;
  }

  @Override
  public Integer poll() {
    if(this.size == 0) return null;
    int value = this.head.GetValue();

    this.head = this.head.GetNext();

    this.size--;

    return value;
  }
}
