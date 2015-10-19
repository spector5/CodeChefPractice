package Trevor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GradeOfSteel {
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			String[] line = br.readLine().split(" ");
			boolean hardness = (Double.parseDouble(line[0]) > 50);
			boolean carbon = (Double.parseDouble(line[1]) < 0.7);
			boolean tensile = (Double.parseDouble(line[2]) > 5600);
			
			if(hardness && carbon && tensile)
				System.out.println(10);
			else if(hardness && carbon)
				System.out.println(9);
			else if(carbon && tensile)
				System.out.println(8);
			else if(hardness && tensile)
				System.out.println(7);
			else if(hardness || carbon || tensile)
				System.out.println(6);
			else
				System.out.println(5);
			
		}
	}

}
