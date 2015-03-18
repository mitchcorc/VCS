
public class SimpleStack<E> implements StackADT<E>
{
	private E[] items;
	private int numItems;
	private static final int INITSIZE = 10;
	
	
	@SuppressWarnings("unchecked")
	public SimpleStack()
	{
		items = (E[])(new Object[INITSIZE]);
		numItems = 0;
	}
	 /**
     * Checks if the stack is empty.
     * @return true if stack is empty; otherwise false
     */
    public boolean isEmpty()
    {
    	if (numItems == 0)
    	{
    		return true;
    	}
    	return false;
    }

    /**
     * Returns (but does not remove) the top item of the stack.
     * @return the top item of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E peek() throws EmptyStackException
    {
    	if (isEmpty())
    	{
    		throw new EmptyStackException();
    	}
    	return items[numItems - 1];
    }

    /**
     * Pops the top item off the stack and returns it. 
     * @return the top item of the stack
     * @throws EmptyStackException if the stack is empty
     */
   public E pop() throws EmptyStackException
    {
	   	if (isEmpty())
   		{
   			throw new EmptyStackException();
   		}
	   	// by subtracting from numItems, it puts the last value out of scope,
	   	// but don't necessarily need to remove from the array
	   	numItems--;
	   	return items[numItems - 1];
    }

    /**
     * Pushes the given item onto the top of the stack.
     * @param item the item to push onto the stack
     * @throws IllegalArgumentException if item is null.
     */
    public void push(E item)
    {
    	if (item == null)
    	{
    		throw new IllegalArgumentException();
    	}
    	if (this.size() == numItems)
    	{
    		expandArray();
    	}
    	items[numItems + 1] = item;
    }
    
    /**
     * Expands the items array to twice the size of the original array
     */
    private void expandArray()
    {
    	@SuppressWarnings("unchecked")
    	// create a temporary array twice the size of the current array
		E[] temp = (E[])(new Object[2*items.length]);
    	
    	for (int i = 0; i < items.length; i++)
    	{
    		temp[i] = items[i];
    	}
    	
    	// reassign items to the temporary array
    	items = temp;
    }
    

    /**
     * Returns the size of the stack.
     * @return the size of the stack
     */
    public int size()
    {
    	return numItems;
    }

    /**
     * Returns a string representation of the stack (for printing).
     * @return a string representation of the stack
     */
    public String toString()
    {
    	String result = "";
    	for (int i = 0; i < items.length; i++)
    	{
    		// not sure if this will do it?
    		result += items[i] + "";
    	}
    	return result;
    }
}

