package charles;

/**
 * @url https://www.codechef.com/problems/TEST
 */
import java.util.Scanner;

class LifeTheUniverseAndEverything {
	public static void main(String[] args) {
		int num;
		Scanner s = new Scanner(System.in);

		while (true) {
			num = s.nextInt();
			if (num != 42) {
				System.out.println(num);
			} else {
				System.exit(0);
			}
		}
	}
}