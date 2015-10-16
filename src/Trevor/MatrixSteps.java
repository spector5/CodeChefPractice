package Trevor;
/***
 * @url https://www.codechef.com/problems/MSTEP
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class MatrixSteps {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out=new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException
	{
		int numTestCases = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < numTestCases; i++)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 1)
			{
				br.readLine();
				out.println("0");
				continue;
			}
			OrderedPair[] coordinates = new OrderedPair[(n*n) + 1];
			
			for(int x = 1; x <= n; x++)
			{
				int num = 0;
				String[] s = br.readLine().split(" ");
				for(int k = 1; k <= n; k++)
				{
					num = Integer.parseInt(s[k - 1]);
					coordinates[num] = new OrderedPair(x,k);
				}
			}
			
			int steps = 0;
			int prevRow;
			int prevCol;
			
			prevRow = coordinates[1].row;
			prevCol = coordinates[1].col;
			
			for(int y = 2; y <= n * n; y++)
			{
				steps += Math.abs(prevRow - coordinates[y].row) + Math.abs(prevCol - coordinates[y].col);
				prevRow = coordinates[y].row;
				prevCol = coordinates[y].col;
			}
			out.println(steps);
			
		}
		out.close();
	}

}

class OrderedPair
{
	int row;
	int col;
	
	public OrderedPair(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
}
