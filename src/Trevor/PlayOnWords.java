package Trevor;
/**
 * @url https://www.codechef.com/problems/WORDS1
 */
import java.io.*;
public class PlayOnWords {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		int[][] wordCounter = new int[26][26];
		
		while(testCase-- > 0)
		{
			int words = Integer.parseInt(br.readLine());
			String line;
			char firstLetter;
			char lastLetter;
			while(words-- > 0)
			{
				line = br.readLine();
				firstLetter = line.charAt(0);
				lastLetter = line.charAt(line.length() - 1);
				wordCounter[firstLetter - 97][lastLetter - 97]++; 	
			}
			
			int colSum;
			int rowSum;
			boolean haveStart = false;
			boolean haveEnd = false;
			boolean possible = true;
			for(int i = 0; i < 26; i++)
			{
				colSum = 0;
				rowSum = 0;
				//sum column and row i
				for(int x = 0; x < 26; x++)
				{
					colSum += wordCounter[x][i];
					rowSum += wordCounter[i][x];
				}
				
				if(rowSum == colSum)
					continue;
				else if(colSum - rowSum == 1)
				{
					if(haveStart)
					{
						possible = false;
						break;
					}
					else
						haveStart = true;
				}
				else if(rowSum - colSum == 1)
				{
					if(haveEnd)
					{
						possible = false;
						break;
					}
					else
						haveEnd = true;
						
				}
				else
				{
					possible = false;
					break;
				}
				
				
			}
			
			if(haveStart && haveEnd && possible)
				System.out.println("Ordering is possible.");
			else
				System.out.println("The door cannot be opened.");
		}
		
		//printArray(wordCounter);
		

	}
	
	public static void printArray(int[][] array)
	{
		System.out.print("  ");
		for(int i = 97; i < 123; i++)
			System.out.print((char)i + " ");
		
		System.out.println();
		for(int i = 0; i < 26; i++)
		{
			System.out.print((char)(i+97) + " ");
			for(int x = 0; x < 26; x++)
				System.out.print(array[i][x] + " ");
			
			System.out.println();
		}
	}

}
