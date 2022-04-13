package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue {

  @Override
  public void offer(Integer x) {
    int val = x.intValue();
    var newQueueStart = new IntQueueNode(val, front);
    front = newQueueStart;
    size++;
  }

}
