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
    if (this.nodes.size() == 0) {
      this.nodes.add(new IntQueueNode(x, null, null));
    } else if (this.nodes.size() < this.maxCapacity) {
      this.nodes.add(new IntQueueNode(x, null, this.nodes.get(this.nodes.size() - 1)));
    }
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    if (this.nodes == null || this.nodes.size() == 0) sb.append("Queue type: LIFO, queue empty");
    else {
      sb.append("Queue type: LIFO,").append("queue size: ").append(this.nodes.size()).append(" values: ");
      for (var node : nodes) {
        sb.append(node.getValue()).append(" ");
      }
    }
    return sb.toString();
  }
}
