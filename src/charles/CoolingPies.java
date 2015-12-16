package charles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
		int good; // the number of pies which can be cooled on racks
		int[] pies; // pies array
		int[] racks; // racks array
		String[] tmp; // for reading input
		// actions for each test case
		for (int i = 0; i < t; i++) {
			/*
			 * read input
			 */
			n = Integer.parseInt(in.readLine()); // num pies/racks
			pies = new int[n];
			racks = new int[n];
			// get pie weights
			tmp = in.readLine().split(" ");
			// parse pie weights
			for (int j = 0; j < n; j++) {
				pies[j] = Integer.parseInt(tmp[j]);
			}
			// get rack weights
			tmp = in.readLine().split(" ");
			// parse rack weights
			for (int j = 0; j < n; j++) {
				racks[j] = Integer.parseInt(tmp[j]);
			}
			/*
			 * sort arrays
			 */
			Arrays.sort(pies);
			Arrays.sort(racks);
		}
		// output
		out.flush();
		// cleanup
		out.close();
	}

	private static int getNumPies(int[] p, int[] r) {
		/*
		 * variables
		 */
		int val = 0;
		int piesRem = p.length;
		/*
		 * actions
		 */
		// while there are still pies
		do {
			// choose lightest pie not on rack
			// if none of racks can hold pie, stop
			// of racks that CAN hold pie, choose lightest
			// if there are no more pies, stop
		} while (true);
		/*
		 * return
		 */
		return val;
	}
}
