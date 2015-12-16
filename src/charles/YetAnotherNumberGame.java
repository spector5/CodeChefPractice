package charles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * link: https://www.codechef.com/problems/NUMGAME
 */
class YetAnotherNumberGame {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int t; // test cases
		int n; // number to be examined in each case
		// input
		t = Integer.parseInt(in.readLine());
		// for each test case
		for (int i = 0; i < t; i++) {
			// get value for test case
			n = Integer.parseInt(in.readLine());
			out.write((n % 2 == 0) ? "ALICE" : "BOB");
			out.write("\n");
		}
		// output
		out.flush();
		// cleanup
		in.close();
		out.close();
	}
}
