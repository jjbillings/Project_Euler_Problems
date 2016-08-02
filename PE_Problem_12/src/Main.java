import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long triangular = 1;
		int i = 2;
		while(getNumDivisors(triangular) < 500)
		{
			triangular += i;
			i++;
		}
		System.out.println("Triangular number: " + triangular);
	}
	//I guess this factorization process is super slow...
	private static int getNumDivisors2(long number)
	{
		int numDiv = 1;
		long max = number/2;
		
		for(int i = 1; i <= max; i++)
		{
			if(number%i == 0)
			{
				numDiv++;
			}
		}
		return numDiv;
	}
	private static int getNumDivisors(long number)
	{
		int numDiv = 0;
		int max = (int) Math.sqrt(number);
		
		for(int i = 1; i <= max; ++i)
		{
			if(number % i == 0)
			{
				numDiv+=2;
			}
		}
		return numDiv;
	
	}
}
