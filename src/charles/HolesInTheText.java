package charles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @url https://www.codechef.com/problems/HOLES
 * NOTE: this yields the wrong answer
 */
class HolesInTheText {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// setup
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// input
		int testCases = Integer.parseInt(br.readLine());
		// actions
		for (int i = 0; i < testCases; i++) {
			System.out.println(numHoles(br.readLine()));
		}
		// cleanup
		br.close();
	}

	public static int numHoles(String phrase) {
		int numHoles = 0;
		for (int i = 0; i < phrase.length(); i++) {
			numHoles += numHoles(phrase.charAt(i));
		}
		return numHoles;
	}

	public static int numHoles(char letter) {
		switch (letter) {
		case 'A':
		case 'D':
		case 'O':
		case 'P':
		case 'R':// these are all the same
			return 1;
		case 'B':
			return 2;
		default: // everything else
			return 0;
		}
	}
}
