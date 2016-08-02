import java.io.*;
import javax.swing.JFileChooser;

public class Main
{
	public static void main(String[] args)
	{
		Parser p = new Parser();
		System.out.println("RUNNING");
		File graphFile;
		FileInputStream is;

		JFileChooser jfc = new JFileChooser();
		int retVal = jfc.showOpenDialog(null);

		if(retVal == JFileChooser.APPROVE_OPTION)
		{
			graphFile = jfc.getSelectedFile();
			try
			{
				is = new FileInputStream(graphFile);
				GraphRepresentation g = GraphRepresentation.getGraph(is);
				GraphRepresentation.DijkstrasAttempt(g);
			}catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("FAILURE");
		}

		
		

	}
}