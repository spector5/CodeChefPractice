package Trevor;
/***
 * @url https://www.codechef.com/problems/PRIME1
 */
import java.io.*;
import java.math.BigInteger;
public class PrimeGenerator {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger min;
		BigInteger max;
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			String[] line = br.readLine().split(" ");
			min = new BigInteger(line[0]);
			max = new BigInteger(line[1]);
			BigInteger temp;
			double num;
			while(min.compareTo(max) < 0)
			{
				num = min.doubleValue();
				//if(isPrime(num))
				System.out.println((int) num);
				
				min = min.nextProbablePrime();
			}
		}
	}
	
	public static boolean isPrime(double num)
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
