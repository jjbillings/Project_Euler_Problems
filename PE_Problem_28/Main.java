import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		long squareSize = 1001;
		long initVal = squareSize * squareSize;

		squareSize = 1000;
		long sum = 0;

		while(initVal > 1)
		{
			for(int i = 0; i < 4; ++i)
			{
				sum += initVal;
				initVal -= squareSize;

				System.out.println(initVal);
			}
			squareSize-=2;
		}
		sum++;
		System.out.println(sum);
	}
}