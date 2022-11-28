
import java.util.*;
import java.util.Iterator;

public class DSAGraph
{
	private DSALinkedList vertices;
	private DSAGraphNode node;
	private QueueUsingLinkedList queue;
	protected int countVertex = 0;
	protected int countEdge = 0;
	
	private class DSAGraphNode
	{
		private String label;
		private boolean visited;
		private DSALinkedList links;
	
		public DSAGraphNode(String inLabel)
		{
			label = inLabel;
			links = new DSALinkedList();
			visited = false;		
		}
	
		public String getLabel()
		{
			return label;
		}
		
		public boolean getVisited()
		{
			return visited;
		}
		
		public void setVisited()
		{
			visited = true;
		}
		
		public void clearVisited()
		{
			visited = false;
		
		}
	
		public DSALinkedList getAdjacent()
		{
			DSALinkedList adjList = new DSALinkedList();
			
			Iterator<?> iterator = links.iterator();
			while(iterator.hasNext() == true)
			{
				DSAGraphNode element = (DSAGraphNode)iterator.next();
				adjList.insertLast(element);
			}
			return adjList;	
		}
	
		public void addEdge(DSAGraphNode vertex)
		{
			links.insertLast(vertex);
		}	
	}
	
	public DSAGraph()
	{
		vertices = new DSALinkedList();	
	}
	
	public void addVertex(String labelOne)
	{
		node = new DSAGraphNode(labelOne);
		vertices.insertLast(node);
		countVertex++;
		Iterator<?> iter = vertices.iterator();
	}
	
	public void addEdge(String labelOne, String labelTwo)
	{
		Iterator<?> iter = vertices.iterator();

			if(hasVertex(labelOne) == false)
			{
				addVertex(labelOne);
			
			}if(hasVertex(labelTwo)==false){
		
				addVertex(labelTwo);
				
			}if(isAdjacent(labelOne,labelTwo) == false){
			
				node = getVertex(labelOne);
				node.addEdge(getVertex(labelTwo));
				countEdge++;
			}
	}
	
	public boolean hasVertex(String label)
	{
		Iterator<?> iter = vertices.iterator();
		boolean vertexAdded = false;
		
		while(iter.hasNext()==true)
		{
			DSAGraphNode element = (DSAGraphNode)iter.next();
			if(element.getLabel().equals(label))
			{
				vertexAdded = true;
			}
		}
		
		return vertexAdded;
	}
	
	public int getVertexCount()
	{
		return countVertex;
	}
	
	public int getEdgeCount()
	{
		return countEdge;
	}
	
	public DSAGraphNode getVertex(String label)
	{
		Iterator<?> iter = vertices.iterator();
		
		while(iter.hasNext() == true)
		{
			DSAGraphNode element = (DSAGraphNode)iter.next();
			if(element.getLabel().equals(label))
			{
				node = element;
			}
		}	
		
		return node;
	}
	
	public DSALinkedList getAdjacent(String label)
	{
		DSALinkedList adjList = new DSALinkedList();
		
		node = getVertex(label);
		adjList = node.getAdjacent();
		
		return adjList;
	}
	
	public boolean isAdjacent (String labelOne, String labelTwo)
	{
		boolean adjPresent = false;
		DSALinkedList adjList = new DSALinkedList();
		
		adjList = getAdjacent(labelOne);
		
		Iterator<?> it = adjList.iterator();
		
		while(it.hasNext() == true)
		{
			DSAGraphNode element = (DSAGraphNode)it.next();
			
			if(element.getLabel().equals(labelTwo))
			{
				adjPresent = true;
			}
		}	
		return adjPresent;
	}
	
	
	public void BFSrec(String label, String label2)
	{
		queue = new QueueUsingLinkedList();
		Iterator<?> iter = vertices.iterator();
		
		while(iter.hasNext() == true)
		{
			DSAGraphNode element = (DSAGraphNode)iter.next();
			element.clearVisited();
		}
	
		node = getVertex(label);
		queue.enqueue(node.getLabel());
		node.setVisited();
		breadthFirstSearch(node, queue, label2);
		
	}
	
	
	public void breadthFirstSearch(DSAGraphNode node, QueueUsingLinkedList queue, String label2)
	{
       	try{
			DSALinkedList adjList = new DSALinkedList();
						
			while((queue.isEmpty() == false ))
			{
				
				adjList = getAdjacent(node.getLabel());
				Iterator<?> it = adjList.iterator();
				
				while(it.hasNext() && ((node.getLabel()).equals(label2)) == false)
				{
					node = (DSAGraphNode)it.next();
				
					if(node.getVisited() == false)
					{
						node.setVisited();
						queue.enqueue(node.getLabel());		
					}
				}
				
				System.out.println(queue.dequeue());
			}
		
		}catch(Exception e){}		
	
	}
	
	public void display()
	{
		Iterator<?> iter = vertices.iterator();
		DSALinkedList adjList = new DSALinkedList();
		
		while(iter.hasNext() == true)
		{
			DSAGraphNode gNode = (DSAGraphNode)iter.next();
			System.out.print(gNode.getLabel()+" --> ");
			
			adjList = getAdjacent(gNode.getLabel());
			Iterator<?> it = adjList.iterator();
			
			while(it.hasNext() == true)
			{
				DSAGraphNode gNode1 = (DSAGraphNode)it.next();
				System.out.print("|");
				System.out.print(gNode1.getLabel());
				System.out.print("|");
			}			
			System.out.println("\n");
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
			
