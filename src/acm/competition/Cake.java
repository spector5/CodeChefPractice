package acm.competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cake {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] removed = { "", "once removed", "twice removed", "thrice removed" };
		String[] cousin = { "1st ", "2nd ", "3rd " };
		String[] greats = { "", "grand", "great-grand", "great-great-grand" };
		int[] kin = new int[2];
		int first;
		int second;
		char gender;
		String[] line = br.readLine().split(" ");
		kin[0] = Integer.parseInt(line[0]);
		first = kin[0];
		kin[1] = Integer.parseInt(line[1]);
		second = kin[1];
		gender = line[2].charAt(0);

		while (kin[0] > 0) {
			String relation = "";
			ArrayList<Integer> k1 = new ArrayList<Integer>();
			ArrayList<Integer> k2 = new ArrayList<Integer>();
			if (kin[0] > kin[1]) {
				int t = kin[0];
				kin[0] = kin[1];
				kin[1] = t;
			}
			int i = kin[0];
			while (i > 0) {
				k1.add(i);
				i = (i - 1) / 2;
			}
			k1.add(0);

			i = kin[1];
			while (i > 0) {
				k2.add(i);
				i = (i - 1) / 2;
			}
			k2.add(0);

			int k1Path;
			int k2Path = 0;
			boolean flag = true;
			for (k1Path = 0; k1Path < k1.size() && flag; k1Path++) {
				k2Path = 0;
				for (int k : k2) {
					if (k == k1.get(k1Path)) {
						flag = false;
						break;
					}

					k2Path++;
				}

			}
			k1Path--;

			if (k1Path == 0 && k2Path <= 4) {

				if (first < second) {
					relation = greats[k2Path - 1];
					relation += "child";
				} else {
					relation = greats[k2Path - 1];
					relation += "parent";
				}

			} else if (k1Path == 1 && k2Path <= 5) {

				if (k2Path == 1)
					relation = "siblings";
				else if (first < second) {
					relation = greats[k2Path - 2];
					relation += (gender == 'M') ? "nephew" : "niece";
				} else {
					relation = greats[k2Path - 2];
					relation += (gender == 'M') ? "uncle" : "aunt";
				}

			} else if (k1Path == 2 && k2Path <= 5) { 

				relation = cousin[0] + "cousin " + removed[k2Path - 2];

			} else if (k1Path == 3 && k2Path <= 6) {

				relation = cousin[1] + "cousin " + removed[k2Path - 3];

			} else if (k1Path == 4 && k2Path <= 7) {

				relation = cousin[2] + "cousin " + removed[k2Path - 4];

			}
			else
				relation = "kin";

			System.out.println(relation);

			line = br.readLine().split(" ");
			kin[0] = Integer.parseInt(line[0]);
			first = kin[0];
			kin[1] = Integer.parseInt(line[1]);
			second = kin[1];
			gender = line[2].charAt(0);

		}

	}

}
