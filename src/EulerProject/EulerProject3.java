package EulerProject;


import java.math.*;

public class EulerProject3 {

	public static void main(String[] args) {
		double num = 600851475143.0;

		double index;
		double largestPrime = 0;
		for (index = Math.floor(Math.sqrt(num)); index > 1; index--) {
			if (num % index == 0 && isPrime(index)) {
				largestPrime = index;
				break;
			}
		}

		System.out.println(largestPrime);

	}

	/**
	 * function is_prime(n : integer) if n ≤ 1 return false else if n ≤ 3 return
	 * true else if n mod 2 = 0 or n mod 3 = 0 return false let i �? 5 while i×i
	 * ≤ n if n mod i = 0 or n mod (i + 2) = 0 return false i �? i + 6 return
	 * true
	 * 
	 * @param num
	 * @return
	 */

	public static boolean isPrime(double num) {
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
