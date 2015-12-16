package charles;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * link: https://www.codechef.com/problems/MAXCOUNT
 *
 */
class CountOfMaximum {
	public static void main(String[] args) throws IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int t; // test cases
		int n; // length of array
		int[] a; // the array
		// int v; // value
		// int c; // count
		// read input
		t = Integer.parseInt(in.readLine());
		/*
		 * for each test case
		 */
		for (int i = 0; i < t; i++) {
			// read input for each case
			n = Integer.parseInt(in.readLine());
			a = new int[n];
			String[] tmp = in.readLine().split(" ");
			// parse input
			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(tmp[j]);
			}
		}
		// output
		out.flush();
		// cleanup
		in.close();
		out.close();
	}
}
