package charles;

/**
 * link: https://www.codechef.com/problems/TSORT
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class TurboSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// PrintWriter out = new PrintWriter(System.out, true);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		// input
		int t = Integer.parseInt(in.readLine()); // num items
		int[] nums = new int[t]; // array of nums
		// actions
		for (int i = 0; i < t; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(nums); // sorts array
		// output
		for (int i = 0; i < t; i++) {
			/*
			 * this is SIGNIFICANTLY faster than System.out.print() for output
			 */
			out.write(nums[i] + "\n");
		}
		// cleanup
		out.flush();// sends output to console
		out.close();
	}
}