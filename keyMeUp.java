import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class keyMeUp 
{

	public static void main(String[] args) 
	{
		String fileNameToLoad = null,stringPath = null, fileNameToSave = null;
		boolean exit = false;
		int input = -1;
		Scanner sc = new Scanner(System.in);
		
		DSAGraph graph = new DSAGraph();
		
		while(exit == false) 
		{
			System.out.println("(0) Exit the program\r\n"
					+ "(1) Load keyboard file\r\n"
					+ "(2) Node operations (find, insert)\r\n"
					+ "(3) Edge operations (find, add)\r\n"
					+ "(4) Display graph\r\n"
					+ "(5) Display graph information\r\n"
					+ "(6) Enter string for finding path\r\n"
					+ "(7) Generate paths\r\n"
					+ "(8) Display path\r\n"
					+ "(9) Save keyboard \r\n");
			
			System.out.print("Please Enter the number you selected: ");
			input = sc.nextInt();
			
			switch (input) 
			{
			case 0: //exit statement condition true, program will exit
				System.out.print("Closing keyMeUp... \r\n");
				exit = true;
				break;
			case 1: //Load Graph from file
				boolean found = false;
				sc.nextLine();
				System.out.print("Please Enter the file name you want to load into the graph: \n ");
				while (found == false) //Validating the file name entered by user
				{
					fileNameToLoad = sc.nextLine();					
					File tmpDir = new File(fileNameToLoad);
					boolean exists = tmpDir.exists();
					if (exists == true) 
					{
						found = true;
						System.out.print("Opening file... \n");
						
						int lineNum = 0; String line = "";
						FileInputStream fileStream;
						BufferedReader bufRdr;
						InputStreamReader isr;						

							try //code to open file
							{
								fileStream = new FileInputStream(fileNameToLoad);
								isr = new InputStreamReader(fileStream);
								bufRdr = new BufferedReader(isr);
								
								while((line = bufRdr.readLine())!= null)
								{
									String[] value = line.split(" "); 
									graph.addEdge(value[0],value[1]);
									graph.addEdge(value[1],value[0]);
									lineNum++;
								}
									fileStream.close();
									System.out.print("Successfully created graph. \n");
							} catch (FileNotFoundException e) 
							{
								System.out.println("File Handling Error \n");
								e.printStackTrace();
							} catch (IOException e) 
							{
								System.out.println("Error: "+e + "\n");
								e.printStackTrace();
							}		
					} else 
						System.out.print("Please enter a valid file name: ");						
				}
				break;
				
					
			case 2: //Node operations (find, insert)
				boolean back = false;
				int option = -1;
				String inputNode = null;
				while (back == false)
				{
					System.out.print("(1) Find Node \n" + "(2) Insert Node \n" +"(3) Go Back \n");
					System.out.print("Please Enter the number you selected: ");
					option = sc.nextInt();
					
					if(option>3 || option<1)
						System.out.print("Please enter a valid number!");
					else
					{
						switch (option)
						{
						case 1:
							sc.nextLine();
							System.out.print("Please Enter the node you want to search for: ");
							inputNode = sc.nextLine();
							if (graph.hasVertex(inputNode) == true)
							{
								System.out.print("VERTEX FOUND in graph. \n");
							}
							else
								System.out.print("VERTEX NOT FOUND in graph. \n");
							break;
						case 2:
							sc.nextLine();
							System.out.print("Please Enter the node you want to Insert: ");
							inputNode = sc.nextLine();
							graph.addVertex(inputNode);
							break;
						case 3:
							back = true; //exit flag set
							break;
						}
					}
				} 
				break;
					
			case 3: //Edge operations (find, add)
				boolean back1 = false;
				int option1, option2 = -1;
				String inputNode1, inputNode2 = null;
				while (back1 == false)
				{
					System.out.print("(1) Find Edge \n" + "(2) Insert Edge \n" +"(3) Go Back \n");
					System.out.print("Please Enter the number you selected: ");
					option1 = sc.nextInt();
					
					if(option1>3 || option1<1)
						System.out.print("Please enter a valid number!");
					else
					{
						switch (option1)
						{
						case 1:
							sc.nextLine();
							System.out.print("Please Enter the first node of the EDGE you want to search for: \n");
							inputNode1 = sc.nextLine();
							System.out.print("Please Enter the second  node of the EDGE you want to search for: \n");
							inputNode2 = sc.nextLine();
							if (graph.isAdjacent(inputNode1, inputNode2) == true)
							{
								System.out.print("EDGE FOUND in graph. \n");
							}
							else
								System.out.print("EDGE NOT FOUND in graph. \n");
							break;
						case 2:
							sc.nextLine();
							System.out.print("Please Enter the first node of the EDGE you want to search for: \n");
							inputNode1 = sc.nextLine();
							System.out.print("Please Enter the second  node of the EDGE you want to search for: \n");
							inputNode2 = sc.nextLine();
							graph.addEdge(inputNode1, inputNode2);
							break;
						case 3:
							back1 = true; //exit flag set
							break;
						}
					}
				}
				break;
					
			case 4: //Display graph
				try {
					graph.display();
				} catch (Exception e1) 
				{
					System.out.print("Graph is empty, cannot display! \n ");
					e1.printStackTrace();
				}
				break;
					
			case 5: //Display graph information (vertex and edge count) 
				System.out.print("The Number of Nodes: " + graph.getVertexCount() + "\n");
				System.out.print("The Number of Edges: " + graph.getEdgeCount() + "\n");
				break;
					
			case 6: //Enter string for finding path
				sc.nextLine();
				System.out.print("Enter a String to find the path: ");
				stringPath = sc.nextLine();
				
				break;
					
			case 7: //Generate paths
				if ((compare(stringPath, null)) == false) 
				{
					String[] strArray = stringPath.split("");
					for (int i = 0; i < stringPath.length(); i++) {

						if (i < (stringPath.length() - 1)) {

							System.out.print((strArray[i]) + " --> " + strArray[i + 1] + "\n");
							graph.BFSrec(strArray[i], strArray[i + 1] + "\n");
						}
					} 
				}
				if ((compare(stringPath, null)) == true)
					System.out.println("Please enter a string first, select option (6)");
				break;
					
			case 8: //Display path
				sc.nextLine();
				System.out.print("Please Enter the file name you want to save the paths to: \n ");
				fileNameToSave = sc.nextLine();
				
				try 
				{
					saveToFile(graph, fileNameToSave, true);
				} catch (Exception e) 
				{
					System.out.print("Graph is empty! \n ");
					e.printStackTrace();
				}
				
				break;
					
			case 9: //Save keyboard
				sc.nextLine();
				System.out.print("Please Enter the file name you want to save the graph to: \n ");
				fileNameToSave = sc.nextLine();	
				
				try 
				{
					saveToFile(graph, fileNameToSave, false);
				} catch (Exception e) 
				{
					System.out.print("Graph is empty! \n ");
					e.printStackTrace();
				}
				
			} //switch case end
			

		}

	}
	
	
public static void saveToFile(DSAGraph graph, String fileName, boolean paths) throws Exception 
{
	FileOutputStream fileStream;
    ObjectOutputStream objectStream;
    try {
        fileStream = new FileOutputStream(fileName);
        objectStream = new ObjectOutputStream(fileStream);
        objectStream.writeObject(graph);
        objectStream.close();
        if (paths == false) 
        {
        	objectStream.writeObject(graph);
			System.out.println("Keyboard saved to : " + fileName + "\n");
		}
        else 
        {	
        	objectStream.writeObject(graph);
        	System.out.println("The Paths are saved to : " + fileName + "\n");
        }
    } catch (Exception e) {
        throw new Exception(e.getMessage());
    }
}

static boolean compare(String str1, String str2) 
{
	  return ((str1 == str2) || (str1 != null && str1.equals(str2)));
	}
	
	

}
