package charles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @url https://www.codechef.com/problems/DOUBLE
 */
class DoubleStrings {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		// input
		int t = Integer.parseInt(in.readLine()); // test cases
		// action
		int numStrs; // number of double strings
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(in.readLine()); // palindrome length
			if (n % 2 != 0) { // if odd
				numStrs = n - 1;
			} else {
				numStrs = n;
			}
			out.write(numStrs + "\n");
		}
		// output
		out.flush();
		// cleanup
		out.close();
	}
}
