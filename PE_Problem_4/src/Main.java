import java.util.ArrayList;
import java.util.Collections;


public class Main {

	/**
	 * Project Euler Problem 4
	 */
	public static void main(String[] args) {
		int largest = -1;
		boolean isPal = true;
		
		start:
		for(int i = 999; i >= 100; --i)
		{
			for(int j = 999; j >= 100; --j)
			{
				int current = i*j;
				
				ArrayList<Integer> num = intToArray(current);
				
				for(int k = 0; k < num.size()/2; k++)
				{
					if(num.get(k) != num.get(num.size() - (k+1)))
					{
						isPal = false;
						break;
					}
				}
				//If it passes the palindrome test
				if(isPal && current > largest)
				{
					largest = current;
				}else
				{
					isPal = true;
				}
			}
		}
		
		System.out.println("The largest Palindrome is: " + largest);
	}
	
	private static ArrayList<Integer> intToArray(int number)
	{
		ArrayList<Integer> numArr = new ArrayList<>();
		
		int count = 0;
		while(number > 0)
		{
			numArr.add(number % 10);
			number /= 10;
		}
		
		return numArr;
	}

}
