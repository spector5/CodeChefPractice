package charles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * link: https://www.codechef.com/problems/NUMGAME
 * 
 * @author 5donuts
 *
 */
class YetAnotherNumberGame {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int t; // test cases
		int n; // number to be examined in each case
		int turn; // turn counter
		// input
		t = Integer.parseInt(in.readLine()); // test cases
		// actions
		/*
		 * need to really think about how to play this game first
		 */
		// for (int i = 0; i < t; i++) {
		// n = Integer.parseInt(in.readLine());
		// turn = 0; // alice goes on even turns
		// while (n > 8) {
		// if (turn % 2 == 0) {
		// // alice's turns
		// if (n % 2 == 0) {
		// n--;// optimal play for even number
		// } else {
		// n--; // need to determine optimal play
		// }
		// } else {
		// // bob's turns
		// if (n % 2 == 0) {
		// n--; // optimal play for even number
		// } else {
		// n--; // need to determine optimal play
		// }
		// }
		// turn++;
		// }
		// }
		// output
		out.flush();
		// cleanup
		out.close();

	}
}
