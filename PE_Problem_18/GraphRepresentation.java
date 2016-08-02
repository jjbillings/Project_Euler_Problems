import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;
public class GraphRepresentation
{

	List<List<Integer>> adjL;
	int[] weights;
	public GraphRepresentation()
	{
		adjL = new ArrayList<>();
	}

	public static GraphRepresentation getGraph(FileInputStream is)
	{
		GraphRepresentation graph = new GraphRepresentation();
		Scanner reader = new Scanner(is);


		//Read in the graph data, populating the adjList and weights array
		int numVertices = reader.nextInt();
		int numEdges;
		graph.weights = new int[numVertices];
		for(int i = 0; i < numVertices; ++i)
		{
			graph.adjL.add(new ArrayList<Integer>());
			graph.weights[i] = reader.nextInt();
			
			numEdges = reader.nextInt();
			for(int j = 0; j < numEdges; ++j)
			{
				graph.adjL.get(i).add(reader.nextInt());
			}
		}
		
		System.out.println(graph.adjL.size());
		

		return graph;
	}


	public static int DijkstrasAttempt(GraphRepresentation g)
	{
		int[] sums = new int[g.weights.length];

		Deque<Integer> q = new LinkedList<>();

		q.add(0);
		sums[0] = g.weights[0];

		while(!q.isEmpty())
		{
			
		}
		return 0;
	}
}