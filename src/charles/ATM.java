package charles;
/*
 * link: https://www.codechef.com/problems/HS08TEST
 */
import java.util.Scanner;

class ATM {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int amt = s.nextInt();
		double bal = s.nextDouble();
		s.close();
		if (amt % 5 == 0 && amt < (bal - 0.5)) {
			bal = (double) (bal - amt - 0.5);
			System.out.printf("%.2f", bal);
		} else {
			System.out.printf("%.2f", bal);
		}
	}
}