package pl.edu.mimuw.queue;

public class IntQueueNode
{

	private final int value;
	private IntQueueNode next;
	private IntQueueNode prev;

	public IntQueueNode(int value, IntQueueNode next, IntQueueNode prev)
	{
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

	public IntQueueNode(int value)
	{
		this(value, null, null);
	}

	public IntQueueNode(IntQueueNode node)
	{
		this(node.value, node.next, node.prev);
	}

	public int getValue()
	{
		return value;
	}

	public IntQueueNode getNext()
	{
		return next;
	}

	public IntQueueNode getPrev()
	{
		return prev;
	}

	public void join(IntQueueNode node)
	{
		next = node;
		node.prev = this;
	}
}
