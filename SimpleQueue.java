
public class SimpleQueue<E> implements QueueADT<E>
{
	private E[] items;
	private int numItems;
	private int frontIndex;
	private int rearIndex;
	private static final int INITSIZE = 10;

	@SuppressWarnings("unchecked")
	public SimpleQueue()
	{
		items = (E[])(new Object[INITSIZE]);
		numItems = 0;
		frontIndex = 0;
		rearIndex = 0;
	}

	/**
	 * Checks if the queue is empty.
	 * @return true if queue is empty; otherwise false.
	 */
	public boolean isEmpty() 
	{
		if (numItems == 0)
			return true;
		
		return false;
	}

	/**
	 * removes and returns the front item of the queue.
	 * @return the front item of the queue.
	 * @throws EmptyQueueException if the queue is empty.
	 */
	public E dequeue() throws EmptyQueueException
	{
		if (numItems == 0)
			throw new EmptyQueueException();

		return null;
	}

	/**
	 * Adds an item to the rear of the queue.
	 * @param item the item to add to the queue.
	 * @throws IllegalArgumentException if item is null.
	 */
	public void enqueue(E item)
	{
		if (item == null)
			throw new IllegalArgumentException();
		
		// check for full array and expand if necessary
		if (items.length == numItems) {
			@SuppressWarnings("unchecked")
			E[] tmp = (E[])(new Object[items.length*2]);
			System.arraycopy(items, frontIndex, tmp, frontIndex,
					items.length-frontIndex);
			if (frontIndex != 0) {
				System.arraycopy(items, 0, tmp, items.length, frontIndex);
			}
			items = tmp;
			rearIndex = frontIndex + numItems - 1;
		}

		// use auxiliary method to increment rear index with wraparound
		rearIndex = incrementIndex(rearIndex);

		// insert new item at rear of queue
		items[rearIndex] = item;
		numItems++;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	private int incrementIndex(int index) 
	{
	    if (index == items.length-1) 
	        return 0;
	    else 
	        return index + 1;
	}


	/**
	 * Returns (but does not remove) the front item of the queue.
	 * @return the top item of the stack.
	 * @throws EmptyQueueException if the queue is empty.
	 */
	public E peek() throws EmptyQueueException
	{
		if (numItems == 0)
		{
			throw new EmptyQueueException();
		}
		return items[frontIndex];
	}

	/**
	 * Returns the size of the queue.
	 * @return the size of the queue
	 */
	public int size()
	{
		return numItems;
	}

	/**
	 * Returns a string representation of the queue (for printing).
	 * @return a string representation of the queue.
	 */
	public String toString()
	{
		if (numItems == 0)
		{
			return "";
		}
		return null;
	}
}
