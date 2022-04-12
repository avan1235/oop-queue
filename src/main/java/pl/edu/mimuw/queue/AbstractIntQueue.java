package pl.edu.mimuw.queue;

import java.util.LinkedList;

public abstract class AbstractIntQueue {
  protected LinkedList<IntQueueNode> nodes;
  protected int maxCapacity;

  public AbstractIntQueue(int firstVal)
  {
    this();
    this.nodes.add(new IntQueueNode(firstVal,null,null));
  }

  public AbstractIntQueue(int firstVal,int maxCapacity)
  {
    this();
    this.nodes.add(new IntQueueNode(firstVal,null,null));
    this.maxCapacity=maxCapacity;
  }

  public AbstractIntQueue()
  {
    this.nodes=new LinkedList<>();
    this.maxCapacity=Integer.MAX_VALUE;
  }

  public abstract void offer(Integer x);

  public Integer peek()
  {
    if(this.nodes==null||this.nodes.size()==0)return null;
    Integer res;
    res=this.nodes.get(0).getValue();
    return res;
  }

  public Integer poll()
  {
    if(this.nodes==null||this.nodes.size()==0)return null;
    Integer res=this.nodes.get(0).getValue();
    this.nodes.remove(0);
    return res;
  }

  @Override
  public abstract String toString();

  public int size()
  {
    return this.nodes.size();
  }

  public boolean empty()
  {
    return this.nodes.size()==0;
  }
}
