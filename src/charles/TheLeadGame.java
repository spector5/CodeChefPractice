package charles;

import java.util.Scanner;

class TheLeadGame {
	public static void main(String[] args) {
		// setup
		Scanner s = new Scanner(System.in);
		// input
		int n = s.nextInt(); // rounds
		int[] p1Scores = new int[n];
		int[] p2Scores = new int[n];
		int[] leads = new int[n];
		int[] mLeads = new int[n];
		for (int i = 0; i < n; i++) {
			p1Scores[i] = s.nextInt();
			p2Scores[i] = s.nextInt();
		}
		// actions
		// determines leads
		for (int i = 0; i < n; i++) {
			leads[i] = p1Scores[i] - p2Scores[i];
			mLeads[i] = Math.abs(leads[i]);
		}
		// determines max lead
		int max = 0;
		int w = 0;
		for (int i = 0; i < n; i++) {
			if (mLeads[i] > max) {
				max = mLeads[i];
				if (leads[i] >= 0) {
					w = 1;
				} else {
					w = 2;
				}
			}
		}
		// output
		System.out.printf("%d %d", w, max);
		// cleanup
		s.close();
	}
}