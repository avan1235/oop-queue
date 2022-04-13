package pl.edu.mimuw.queue;

public class LIFOIntQueue extends AbstractIntQueue
{
	/**
	 * @return the head of this queue, or {@code null} if this queue is empty
	 * and don't remove the element from the queue
	 */
	@Override
	public Integer peek()
	{
		if (size() == 0)
			return null;
		return getFirstElement();
	}

	/**
	 * @return the head of this queue, or {@code null} if this queue is empty
	 * and remove the element from the queue
	 */
	@Override
	public Integer poll()
	{
		Integer tmp = peek();
		removeFirstElement();
		return tmp;
	}
}