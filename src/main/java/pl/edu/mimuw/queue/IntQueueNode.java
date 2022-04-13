package pl.edu.mimuw.queue;
import java.lang.Integer;
public class IntQueueNode {

  private final int value;
  private IntQueueNode next;

  public IntQueueNode(int value, IntQueueNode next) {
    this.value = value;
    this.next = next;
  }

  public IntQueueNode getNext(){
    return next;
  }

  public Integer getValue(){
    return Integer.valueOf(value);
  }
  /**
   * setNext is safe - queue never gives user access to currently used IntQueueNode
   */
  public void setNext(IntQueueNode next){
    this.next = next;
  }

  public IntQueueNode(int value) {
    this(value, null);
  }
}
