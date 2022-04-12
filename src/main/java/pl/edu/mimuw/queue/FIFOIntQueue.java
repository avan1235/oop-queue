package pl.edu.mimuw.queue;

public class FIFOIntQueue extends AbstractIntQueue {

  public FIFOIntQueue(int firstVal, int maxCapacity) {
    super(firstVal, maxCapacity);
  }

  public FIFOIntQueue(int firstVal) {
    super(firstVal);
  }

  public FIFOIntQueue() {
    super();
  }

  @Override
  public void offer(Integer x) {
    if (this.nodes.size() == 0) {
      this.nodes.add(new IntQueueNode(x, null, null));
    } else if (this.nodes.size() < this.maxCapacity) this.nodes.add(0, new IntQueueNode(x, this.nodes.get(0), null));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (this.nodes == null || this.nodes.size() == 0) sb.append("Queue type: FIFO, queue empty");
    else {
      sb.append("Queue type: FIFO,").append("queue size: ").append(this.nodes.size()).append(" values: ");
      for (var node : nodes) {
        sb.append(node.getValue()).append(" ");
      }
    }
    return sb.toString();
  }
}
