package charles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

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
		int v; // value
		int c; // count
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
			/*
			 * get values & counts
			 */
			int[] nums = valueAndCount(a);
			// out.write(String.format("%d %d", nums[]));
			out.write(String.format("%d %d\n", nums[0], nums[1]));
		}
		// output
		out.flush();
		// cleanup
		in.close();
		out.close();
	}

	/**
	 * determines the value & count of that value
	 * 
	 * @param a
	 *            array of integers to examine
	 * @return an array where that {@code array[0]} is the value and that
	 *         {@code array[1]} is the count
	 */
	private static int[] valueAndCount(int[] a) {
		// variables
		int[] c = new int[10000]; // counts
		int[] res = new int[2]; // return array
		int min; // smallest maxima
		/*
		 * actions
		 */
		// get the counts for each value
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (a[i] == j + 1) {
					c[j]++;
				}
			}
		}
		// determine values with max counts
		ArrayList<Integer> ali = getMaxima(c);
		min = Collections.min(ali);
		/*
		 * return result
		 */
		res[0] = min + 1;
		res[1] = c[min];
		return res;
	}

	/**
	 * method to get the maxima of an array
	 * 
	 * @param c
	 *            array to examine
	 * @return indices of the maxima of the array
	 */
	private static ArrayList<Integer> getMaxima(int[] c) {
		// variables
		ArrayList<Integer> maxima = new ArrayList<>();
		int max = c[0];
		// get the maximum value
		for (int i = 1; i < c.length; i++) {
			max = (c[i] > max) ? c[i] : max;
		}
		// get indices of max value
		for (int i = 0; i < c.length; i++) {
			if (c[i] == max) {
				maxima.add(i);
			}
		}
		// return indices
		return maxima;
	}
}
