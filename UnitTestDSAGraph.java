public class UnitTestDSAGraph
{
	public static void main(String args[])
	{
        int i = 0;
        DSAGraph graph = new DSAGraph();
        String sTestString;
        Object nodeValue;
        
      //ADD Vertex
        try 
        {
            System.out.print("Testing add vertex : ");
            
            graph.addVertex("1");
            graph.addVertex("4");
            graph.addVertex("2");
           
           

            System.out.println("PASSED!\n");

        } catch(Exception e) { System.out.println("FAILED!\n"); }

        //ADD EDGE
        try {

            System.out.print("Testing add edge: ");
            
            graph.addEdge("1", "5");
            graph.addEdge("1", "4");
            graph.addEdge("1", "2");
            graph.addEdge("2", "7");
            graph.addEdge("2", "6");
            graph.addEdge("2", "3");
           

            System.out.println("PASSED!\n");

        } catch(Exception e) { System.out.println("FAILED!\n"); }
        
        

       //HAS VERTEX
        try 
        {
            System.out.print("Testing has vertex method: ");
       
            if (graph.hasVertex("1") == false)
                throw new IllegalArgumentException("FAILED!\n");
                
            if (graph.hasVertex("2") == false)
                throw new IllegalArgumentException("FAILED!\n");
                
            if (graph.hasVertex("7") == false)
                throw new IllegalArgumentException("FAILED!\n");
                
            System.out.println("PASSED!\n");
        } 
        catch(Exception e) { System.out.println("FAILED!\n"); 
        }
        
        
       //GET VERTEX COUNT
       
        try {
            System.out.print("Testing get vertex count: ");
            i = graph.getVertexCount();
            if (i != 7)
                throw new IllegalArgumentException("FAILED!\n");
            System.out.println("PASSED!\n");
        } catch(Exception e) { System.out.println("FAILED!\n"); }
        

       //GET EDGE COUNT
        try 
        {
            System.out.print("Testing get edge count: ");
            i = graph.getEdgeCount();
            if (i != 6)
                throw new IllegalArgumentException("FAILED!\n");
            System.out.println("PASSED!\n");
            
        } catch(Exception e) { System.out.println("FAILED!\n"); }

	//IS ADJACENT
        try 
        {
            System.out.print("Testing is adjacent");
            if (graph.isAdjacent("2","7") == false)
                throw new IllegalArgumentException("FAILED!\n");
                
             System.out.println("PASSED!\n");
            
        } catch(Exception e) { System.out.println("FAILED!\n"); }
        
        //DISPLAY
        try
        {
            
            System.out.println("Testing display method: \n");   
            graph.display();
           
        } catch(Exception e) 
        { }
        
        //BFS
         try 
         {
       	System.out.println("Testing BFS from 1 to 7");   
       	graph.BFSrec("1", "7");
       	System.out.println("\n");
	
	 } catch(Exception e) 
         { System.out.println("FAILED!\n"); 
	 }

    }
}
