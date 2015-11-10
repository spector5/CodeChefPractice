package charles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @url https://www.codechef.com/problems/COOLING
 * @author 5donuts
 *
 */
class CoolingPies {
	public static void main(String[] args) throws IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		// input
		int t = Integer.parseInt(in.readLine()); // test cases
		int n; // number if pies & racks for each test case
		int[] pies; // pies array
		int[] racks; // racks array
		// actions
		/*
		 * gets pie and rack weights
		 */
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(in.readLine());
			pies = new int[n];
			racks = new int[n];
			// reads pie weights
			for (int j = 0; j < n; j++) {
				pies[j] = Integer.parseInt(in.readLine());
			}
			// reads rack weights
			for (int j = 0; j < n; j++) {
				racks[j] = Integer.parseInt(in.readLine());
			}
		}
		/*
		 * determine how many pies can fit on each rack
		 */
		// output
		out.flush();
		// cleanup
		out.close();
	}
}
