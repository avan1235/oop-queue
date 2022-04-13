package pl.edu.mimuw.queue;

public abstract class AbstractIntQueue
{
	private IntQueueNode start;
	private IntQueueNode end;
	private int numberOfElements;

	AbstractIntQueue()
	{
		start = end = null;
		numberOfElements = 0;
	}

	protected Integer getFirstElement()
	{
		return start.getValue();
	}

	protected Integer getLastElement()
	{
		return end.getValue();
	}

	protected void removeFirstElement()
	{
		start = start.getNext();
		numberOfElements--;
	}

	protected void removeLastElement()
	{
		end = end.getPrev();
		numberOfElements--;
	}

	/**
	 * Adds element to the queue.
	 *
	 * @throws NullPointerException if the specified element is null
	 */
	public void offer(Integer x) throws java.lang.NullPointerException
	{
		if (x == null)
			throw new NullPointerException();
		if (start == null)
		{
			start = new IntQueueNode(x);
			end = start;
			start.join(end);
		}
		else if (start == end)
		{
			start = new IntQueueNode(x);
			start.join(end);
		}
		else
		{
			IntQueueNode temp = new IntQueueNode(start);
			start = new IntQueueNode(x);
			start.join(temp);
			temp.join(temp.getNext());
		}
		numberOfElements++;
	}

	/**
	 * @return the head of this queue, or {@code null} if this queue is empty
	 * and don't remove the element from the queue
	 */
	abstract public Integer peek();

	/**
	 * @return the head of this queue, or {@code null} if this queue is empty
	 * and remove the element from the queue
	 */
	public abstract Integer poll();

	/**
	 * @return readable representation of ordered queue elements
	 */

	public String toString()
	{
		StringBuilder s = new StringBuilder("Queue elements: {");
		if (size() == 0)
		{
			s.append('}');
			return s.toString();
		}
		var begin = start;
		while (begin != end)
		{
			s.append(begin.getValue()).append(", ");
			begin = begin.getNext();
		}
		s.append(begin.getValue()).append("}\n");
		return s.toString();
	}

	/**
	 * @return the number of elements in this queue
	 */
	public int size()
	{
		return numberOfElements;
	}
}
