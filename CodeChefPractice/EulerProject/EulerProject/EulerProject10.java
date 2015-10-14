package EulerProject;

import java.math.BigInteger;

public class EulerProject10 {

	public static void main(String[] args) {
		long sum = 0;
		for (int i = 0; i < 2000000; i++) {
			if (isPrime(i))
				sum += i;

		}

		System.out.println(sum);
	}

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		else if (num <= 3)
			return true;
		else if (num % 2 == 0 || num % 3 == 0)
			return false;

		int i = 5;
		while (i * i <= num) {
			if (num % i == 0 || num % (i + 2) == 0)
				return false;

			i += 6;
		}
		return true;
	}

}
