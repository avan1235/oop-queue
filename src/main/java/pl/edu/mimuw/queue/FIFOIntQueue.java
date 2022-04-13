package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {
  private IntQueueNode back;

  @Override
  public void offer(Integer x) {
    var newQueueBack = new IntQueueNode(x.intValue());
    size++;
    if(front == null){
      front = newQueueBack;
      back = newQueueBack;
    }
    else {
      back.setNext(newQueueBack);
      back = newQueueBack;
    }
  }

  @Override
  public Integer poll() {
    if (front == null) {
      return null;
    }
    //gwarantujemy, że back pustej kolejki jest zawsze nullem
    if (front.getNext() == null) {
      back = null;
    }
    return super.poll();
  }
}
