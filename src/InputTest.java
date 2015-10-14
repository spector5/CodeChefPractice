/**
 * @url https://www.codechef.com/problems/INTEST
 */
import java.io.*;
public class InputTest {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int lines = Integer.parseInt(line[0]);
		int mod = Integer.parseInt(line[1]);
		int counter = 0;
		
		for(int i = 0; i < lines; i++)
		{
			int num = Integer.parseInt(br.readLine());
			if(num % mod == 0)
				counter++;
		}
		
		System.out.println(counter);

	}

}
