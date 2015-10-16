package Trevor;
/**
 * @url https://www.codechef.com/OCT15/problems/WDTBAM
 */
import java.io.*;

public class DaringMillionaire {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCases; i++)
		{
			int arrayLength = Integer.parseInt(br.readLine());
			char[] array1 =  new char[arrayLength];
			char[] array2 = new char[arrayLength];
			int[] winnings = new int[arrayLength + 1];
			
			for(int x = 0; x < arrayLength; x++)
			{
				array1[x] =(char) br.read();
			}
			br.readLine();
			
			for(int x = 0; x < arrayLength; x++)
			{
				array2[x] =(char) br.read();
			}
			
			br.readLine();
			String line = br.readLine();
			String[] parts = line.split(" ");
			
			for(int x = 0; x < arrayLength + 1; x++)
			{
				winnings[x] = Integer.parseInt(parts[x]);
			}
			
			int correct = 0;
			for(int x = 0; x < arrayLength; x++)
			{
				if(array1[x] == array2[x])
					correct++;
			}
			
			if(correct == arrayLength)//if he gets all correct then he
			{							// will have to get the most winnings regardless of order
				System.out.println(winnings[arrayLength]);
				continue;
			}

			int max = winnings[0];
			for(int x = 1; x <= correct; x++)
			{
				if(winnings[x] > max)
					max = winnings[x];
			}
			
			System.out.println(max);
			
		}
	}

}
