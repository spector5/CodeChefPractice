package charles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * link: https://www.codechef.com/problems/CIELAB
 *
 */
class CielAndAMinusBProblem {
	public static void main(String[] args) throws IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		/*
		 * actions
		 */
		// read input
		String[] input = in.readLine().split(" ");
		// parse input
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int diff = a - b;
		int res; // the result to output
		// cases
		if (diff == 1) {
			// so you don't get zero
			res = diff + 1;
		} else if (diff % 10 == 9) {
			// in case adding one would increase the number of digits
			res = diff - 1;
		} else {
			// all other cases
			res = diff + 1;
		}
		out.write(String.format("%d\n", res));
		/*
		 * end actions
		 */
		// output
		out.flush();
		// cleanup
		out.close();
		in.close();
	}
}
