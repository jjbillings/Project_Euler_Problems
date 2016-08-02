import java.io.*;
import java.util.*;

public class Parser
{
	public Parser()
	{
		try
		{
			FileInputStream is = new FileInputStream("graphData.txt");
			BufferedReader bis = new BufferedReader(new InputStreamReader(is));
			PrintWriter writer = new PrintWriter("outputData.txt");
		
			int numRows = countLines(bis);
			int numVertices = (numRows * (numRows + 1))/2;

			int[][] weights = readWeights(bis, numRows);
			
			printGraph(weights,numVertices,numRows, 2,writer);

			System.out.println("Operations Complete...");
			bis.close();
			is.close();
			writer.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void printGraph(int[][] weights, int numVertices, int numRows, int numAdjacent, PrintWriter writer) throws IOException
	{
		writer.println(numVertices);
		int n = 1;
		for(int i = 0; i < numRows; ++i)
			{
				for(int j = 0; j <= i; j++)
				{
					writer.print(weights[i][j] + " ");
					if(i < (numRows - 1))
					{
						writer.print(numAdjacent + " " + (n+(i+1)) + " " + (n+(i+2)) + "\n");
					}else
					{
						writer.print(0 + " \n");
					}
					n++;
				}
			}
	}


	public int[][] readWeights(BufferedReader reader, int numRows) throws IOException
	{
		reader.mark(100000);
		int[][] weights = new int[15][15];

		for(int i = 0; i < numRows; ++i)
		{

			String line = reader.readLine();
			String[] ss = line.trim().split("\\s+");
			for(int k = 0; k <= i; ++k)
			{
				weights[i][k] = Integer.parseInt(ss[k]);
			}
		}

		reader.reset();

		return weights;
	}

	public int countLines(BufferedReader reader) throws IOException
	{
		reader.mark(1000000);
		int numLines = 0;
		while(reader.readLine() != null)
		{
			numLines++;
		}
		reader.reset();
		return numLines;
	}
}