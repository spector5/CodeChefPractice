package Trevor;
/**
 * @url https://www.codechef.com/OCT15/problems/SUBINC
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NonDecreasingArrays {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		int arrayLength = 0;
		
		for(int i = 0; i < testCases; i++)
		{
			arrayLength = Integer.parseInt(br.readLine());
			int[] array = new int[arrayLength];
			String line = br.readLine();
			String[] elements = line.split(" ");
			int x = 0;
			for(String element : elements)
			{
				array[x++] = Integer.parseInt(element);
			}
			
			int counter = 0; 
			for(int start = 0; start < array.length; start++)
			{
				int t = 1;
				while((start + t) < array.length && array[start + (t-1)] <= array[start + t])
				{
					t++;
				}
				
				counter += (t*(t+1))/2;
				start += t - 1;
			}
			
			System.out.println(counter);
		}
	}

}
