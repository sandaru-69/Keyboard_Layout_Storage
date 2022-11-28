
import java.util.*;

public class DSALinkedList implements Iterable
{
	 DSAListNode head;
	protected DSAListNode currentNode;
	protected DSAListNode previousNode;
	protected Object nodeValue;
	
	public Iterator iterator()
	{
		return new MyLinkedListIterator(this);
	}
	
	private class MyLinkedListIterator implements Iterator
	{
		private DSAListNode iterNext; 
		
		public MyLinkedListIterator (DSALinkedList theList)
		{
			iterNext = theList.head;
		}
		
		public boolean hasNext()
		{
			return(iterNext != null);
		}
		
		public Object next()
		{
			Object value;
			
			if(hasNext()==false)
			{
				value = null;
			}else{
				value = iterNext.getValue();
				iterNext = iterNext.getNext();
			}
		return value;
		}
		
	}
	
	private class DSAListNode 
	{
		public Object value;
		public DSAListNode next;
		public DSAListNode prev;
		
		public DSAListNode(Object data)
		{
			next = null;
			prev = null;
			value = data;	
		}
		
		public Object getValue()
		{
			return value;
		}
			
		public void setValue(Object data)
		{
			value = data;
		}
			
		public DSAListNode getNext()
		{
			return next;
		}
			
		public void setNext(DSAListNode newNext)
		{
			next = newNext;
		}
	}
	
	public DSALinkedList()
	{
		head = null;
	}
	
	public void insertFirst(Object newValue) 
	{
		DSAListNode newNode = new DSAListNode(newValue);
		
		if(isEmpty()==true)
		{
			head = newNode;
		}else{
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void insertLast(Object newValue) 
	{
		DSAListNode newNode = new DSAListNode(newValue);
		
		currentNode = head;
		newNode.next = null;
		
		if(isEmpty()==true)
		{
			newNode.prev = null;
			head = newNode;
		}else{
			
			while(currentNode.next != null)
			{
				currentNode = currentNode.next;
			}
			
			currentNode.next = newNode;
			newNode.prev = currentNode;
		}
	}
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if(head == null)
		{
			empty = true;
		}
		
		return empty;
	}
	
	public Object peekFirst() throws LinkedListIsEmptyException
	{
		
		if(isEmpty()==true)
		{
			throw new LinkedListIsEmptyException("Linked list is empty!");
		}else{
			nodeValue = head.value;
		}
		
		return nodeValue;
	}
	
	public Object peekLast() throws LinkedListIsEmptyException
	{
		if(isEmpty()==true)
		{
			throw new LinkedListIsEmptyException("Linked list is empty!");
		}else{
			currentNode = head;
			
			while(currentNode.next != null)
			{
				currentNode = currentNode.next;
			}
			
			nodeValue = currentNode.value;
		}
		
		return nodeValue;
	}
	
	public Object removeFirst() throws LinkedListIsEmptyException
	{
		if(isEmpty()==true)
		{
			throw new LinkedListIsEmptyException("Linked list is empty!");
		}else{
			nodeValue = head.value;
			head = head.next;
		}
		return nodeValue;
	}
	
	public Object removeLast() throws LinkedListIsEmptyException
	{
		if(isEmpty()==true)
		{
			throw new LinkedListIsEmptyException("Linked list is empty!"); 
		}else{
			currentNode = head;
			previousNode = null;
			
			while(currentNode.value != null)
			{
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			
			previousNode.next = null;
			nodeValue = currentNode.value;
		}
		
		return nodeValue;
	}
	
	public int getCount()
   	{
        	DSAListNode temp = head;
        	int count = 0;
        	while (temp != null)
        	{
        	    count++;
            	    temp = temp.next;
        	}
        	
        	return count;
    }
}
	
	 
	
	
		
		
