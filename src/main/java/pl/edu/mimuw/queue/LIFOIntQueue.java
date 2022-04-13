package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {

  @Override
  public void offer(Integer x) {
    this.size++;
    IntQueueNode newNode = new IntQueueNode(x);
    if (this.first != null) {
      newNode.setNext(this.first);
    }
    this.first = newNode;
  }

  @Override
  public Integer poll() {
    if(this.first == null)
      return null;
    Integer output = this.first.getValue();
    this.first = this.first.getNext();
    this.size--;
    return output;
  }
}
