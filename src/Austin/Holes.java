package Austin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// url: https://www.codechef.com/problems/HOLES
public class Holes 
{

	public static void main(String[] args) throws IOException 
	{
		String line;
		int tests;
		int holes = 0;
		int i = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		tests = Integer.parseInt(line);
		
		while (i < tests)
		{
			line = br.readLine();
			for (int l = 0; l < line.length(); l++)
			{
				if (line.charAt(l) == 'A' || line.charAt(l) == 'D' || line.charAt(l) == 'O' || 
					line.charAt(l) == 'P' || line.charAt(l) == 'R' || line.charAt(l) == 'Q')
				{
					holes++;
				}
				if (line.charAt(l) == 'B')
				{
					holes += 2;
				}
			}
			System.out.println(holes);
			i++;
			holes = 0;
		}

	}

}
