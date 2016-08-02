import java.util.ArrayList;
import java.util.Collections;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int largest = -1;
		for(int i = 999; i >= 100; --i)
		{
			for(int j = 999; j >= 100; --j)
			{
				int current = i * j;
				int savedCurrent = current;
				ArrayList<Integer> num1 = new ArrayList<>();
				ArrayList<Integer> num2 = new ArrayList<>();
				while(current > 0)
				{
					num1.add(current % 10);
					num2.add(current % 10);
					current /= 10;
				}
				
				Collections.reverse(num2);
				if(num1.equals(num2) && savedCurrent > largest)
				{
					largest = savedCurrent;
				}
			}
		}
		System.out.println("The largest palindrome is: " + largest);
	}

}
