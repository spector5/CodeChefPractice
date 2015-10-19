package Trevor;
/***
 * @url https://www.codechef.com/problems/PRIME1
 */
import java.io.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
public class PrimeGenerator {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		//long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			String[] numbers = br.readLine().split(" ");
			int min = Integer.parseInt(numbers[0]);
			int max = Integer.parseInt(numbers[1]);
			/*int min = 1000;
			int max = 101000;*/
			//String line = "";
			for(int i = min; i <= max; i++)
			{
				if(isPrime(i))
					System.out.println(i);

			}
			//System.out.println(line);
		}
		
		/*long endTime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("m:s:S");
		System.out.println("\nTotal time [min:sec:milli]: " + sdf.format(new Date(endTime - startTime)));*/
	}
	
	public static boolean isPrime(int num)
	{
		if(num <= 1)
			return false;
		else if(num <= 3)
			return true;
		else if(num % 2 == 0 || num % 3 == 0)
			return false;
		
		int i = 5;
		while(i * i <= num)
		{
			if(num % i == 0 || num % (i + 2) == 0)
				return false;
			
			i += 6;
		}
		
		return true;
	}	

}
