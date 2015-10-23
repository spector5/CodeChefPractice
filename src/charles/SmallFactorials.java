package charles;
/*
 * link: https://www.codechef.com/problems/FCTRL2
 */
import java.math.BigInteger; // needed due to number sizes
import java.util.Scanner;

class SmallFactorials {
	public static void main(String[] args) {
		// setup
		Scanner s = new Scanner(System.in);
		// input
		int t = s.nextInt(); // test cases
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			BigInteger fact = BigInteger.valueOf(1);
			for (int j = 1; j <= n; j++) {
				fact = fact.multiply(BigInteger.valueOf(j));
			}
			System.out.println(fact);
		}
	}
}