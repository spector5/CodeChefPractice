package charles;
/**
 * @url https://www.codechef.com/problems/FCTRL
 */
import java.util.Scanner;

class Factorial {
	public static void main(String[] args) {
		// setup
		Scanner s = new Scanner(System.in);
		// input/output
		int t = s.nextInt(); // number of values
		for (int i = 0; i < t; i++) {
			System.out.println(trailingZeros(s.nextInt()));
		}
		// cleanup
		s.close();
	}

	public static int trailingZeros(int num) {
		int exp = 1;
		int zeros = 0;
		int result;
		do {
			result = (int) (num / Math.pow(5, exp));
			exp++;
			zeros += result;
		} while (result > 1);
		return zeros;
	}
}