import java.util.*;
import java.util.Iterator;

public class QueueUsingLinkedList extends DSALinkedList implements Iterable
{	
	//declaring class fields
	private DSALinkedList queue;
	
	public Iterator iterator() 
	{
		return queue.iterator();
 	}
	
	public QueueUsingLinkedList()
    	{
        	this.head = null;
    	}
	 
	//Initializing getters
	
        /*ACCESSOR: isEmpty
	IMPORT: none
	EXPORT: empty(boolean)*/
	
	public boolean isEmpty()
	{
		boolean empty = super.isEmpty();
		
		return empty;
	}
	
	public void enqueue(Object value)
	{
		super.insertLast(value);
	}
		
	public Object dequeue() throws LinkedListIsEmptyException
	{
		Object topVal = super.removeFirst();
		return topVal;
	}
	
	public Object peek() throws LinkedListIsEmptyException
	{
		Object frontVal = super.peekFirst();
		return frontVal;
	}
}
