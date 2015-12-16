package acm.competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * This is the code for problem A we did for the 2015 acm competition at Radford
 * Note: The weird name of this file formed a sentence with the other files, "The Cake is a lie"
 */
public class The {
	public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] pattern = new double[4];
		String[] line = br.readLine().split(" ");

		for (int i = 0; i < 4; i++)
			pattern[i] = Double.parseDouble(line[i]);

		while (notNegative(pattern)) {
			int pos = 0;
			for (double num : pattern) {
				if (num == -1)
					break;
				pos++;
			}

			switch (pos) {
			case 0:
				pos0(pattern);
				break;
			case 1:
				pos1(pattern);
				break;
			case 2:
				pos2(pattern);
				break;
			case 3:
				pos3(pattern);
				break;
			}

			line = br.readLine().split(" ");

			for (int i = 0; i < 4; i++)
				pattern[i] = Double.parseDouble(line[i]);
		}
		wr.flush();
	}

	public static boolean notNegative(double[] pattern) {
		for (double num : pattern)
			if (num != -1)
				return true;
		return false;
	}

	public static void pos0(double[] pattern) throws IOException {
		boolean artFlag = true;
		boolean geoFlag = true;
		double num = 0;
		int place;

		double art = pattern[2] = pattern[1];
		if (pattern[2] + art != pattern[3])
			artFlag = false;

		double geo = pattern[2] / pattern[1];
		if (pattern[2] * geo != pattern[3])
			geoFlag = false;

		if (!geoFlag && !artFlag) {
			wr.write("-1\n");
			return;
		}

		if (artFlag)
			num = pattern[1] - art;

		if (geoFlag)
			num = pattern[1] / geo;

		if (num >= 1 && num <= 1000000 && num == (int) Math.floor(num)) {
			place = (int) Math.floor(num);
			wr.write(place + "\n");
		}

		else
			wr.write("-1\n");
	}

	public static void pos1(double[] pattern) throws IOException {
		boolean artFlag = true;
		boolean geoFlag = true;
		double num = 0;
		int place;

		double art = pattern[3] - pattern[2];
		if (pattern[2] - (2 * art) != pattern[0])
			artFlag = false;

		double geo = pattern[3] / pattern[2];
		double mid = pattern[2] / geo;
		if ((mid / geo) != pattern[0])
			geoFlag = false;

		if (!geoFlag && !artFlag) {
			wr.write("-1\n");
			return;
		}

		if (artFlag)
			num = pattern[2] - art;

		if (geoFlag)
			num = pattern[2] / geo;

		if (num >= 1 && num <= 1000000 && num == (int) Math.floor(num)) {
			place = (int) Math.floor(num);
			wr.write(place + "\n");
		} else
			wr.write("-1\n");
	}

	public static void pos2(double[] pattern) throws IOException {
		boolean artFlag = true;
		boolean geoFlag = true;
		double num = 0;
		int place;

		double art = pattern[1] - pattern[0];
		if (pattern[1] + (2 * art) != pattern[3])
			artFlag = false;

		double geo = pattern[1] / pattern[0];
		double mid = pattern[1] * geo;
		if ((mid * geo) != pattern[3])
			geoFlag = false;

		if (!geoFlag && !artFlag) {
			wr.write("-1\n");
			return;
		}

		if (artFlag)
			num = pattern[1] + art;

		if (geoFlag)
			num = pattern[1] * geo;

		if (num >= 1 && num <= 1000000 && num == (int) Math.floor(num)) {
			place = (int) Math.floor(num);
			wr.write(place + "\n");
		} else
			wr.write("-1\n");
	}

	public static void pos3(double[] pattern) throws IOException {
		boolean artFlag = true;
		boolean geoFlag = true;
		double num = 0;
		int place;

		double art = pattern[1] - pattern[0];
		if (pattern[1] + art != pattern[2])
			artFlag = false;

		double geo = pattern[1] / pattern[0];
		if ((pattern[1] * geo) != pattern[2])
			geoFlag = false;

		if (!geoFlag && !artFlag) {
			wr.write("-1\n");
			return;
		}

		if (artFlag)
			num = pattern[2] + art;

		if (geoFlag)
			num = pattern[2] * geo;

		if (num >= 1 && num <= 1000000 && num == (int) Math.floor(num)) {
			place = (int) Math.floor(num);
			wr.write(place + "\n");
		} else
			wr.write("-1\n");
	}
}
