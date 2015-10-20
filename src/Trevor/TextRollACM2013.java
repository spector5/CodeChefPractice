/**
 * @url https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&category=618&page=show_problem&problem=4556
 */
package Trevor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TextRollACM2013 {

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lineNum;
		while((lineNum = Integer.parseInt(br.readLine())) != 0)
		{
			String[] lines = new String[lineNum];
			for(int i = 0; i < lineNum; i++)
			{
				lines[i] = br.readLine();
			}
			
			int currentPosition = 0;
			for(String line : lines)
			{
				for(int i = currentPosition; i < line.length() - 1; i++)
				{
					if(line.charAt(i) == ' ')
						break;
					else
						currentPosition++;		
				}
			}
			
			System.out.println(currentPosition + 1);
		}
	}
}
