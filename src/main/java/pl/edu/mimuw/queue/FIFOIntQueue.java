package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {

  private IntQueueNode tail;

  public FIFOIntQueue() {
    this.tail = null;
  }

  @Override
  public void offer(Integer x) {
    if (x == null) throw new NullPointerException();

    final IntQueueNode newN = new IntQueueNode(x);

    if (this.size != 0) {
      this.tail.SetNext(newN);
    } else {
      this.head = newN;
    }

    this.tail = newN;
    this.size++;
  }

  @Override
  public Integer poll() {
    if (this.size == 0) return null;

    int value = this.head.GetValue();
    this.head = this.head.GetNext();
    this.size--;

    return value;
  }


}
