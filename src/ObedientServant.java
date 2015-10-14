/**
 * @url https://www.codechef.com/problems/FLOW008
 */
import java.io.*;

class ObedientServant {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out=new PrintWriter(System.out);
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int in = Integer.parseInt(br.readLine());
		for(int x = 0; x < in; x++)
		{
			int num = Integer.parseInt(br.readLine());
			if(num < 10)
				out.println("What an obedient servant you are!");
			else
				out.println(-1);
		}
		out.close();
	}
}
