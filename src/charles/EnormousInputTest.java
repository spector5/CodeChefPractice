package charles;
/**
 * @url https://www.codechef.com/problems/INTEST
 */
import java.util.Scanner;

class EnormousInputTest {
	public static void main(String[] args) {
		// setup
		Scanner s = new Scanner(System.in);
		int numDiv = 0;
		// input
		int n = s.nextInt(); // number of nums
		int k = s.nextInt(); // divby test
		for (int i = 0; i < n; i++) {
			if (s.nextInt() % k == 0) {
				numDiv++;
			}
		}
		// output
		System.out.println(numDiv);
		// cleanup
		s.close();
	}
}