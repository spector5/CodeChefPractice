package EulerProject;

public class EulerProject7 {

	public static void main(String[] args) {
		int primeCounter = 0;
		double num = 0;
		while (primeCounter < 10001) {
			num++;
			if (isPrime(num)) {
				primeCounter += 1;
			}

		}
		System.out.println(num);
	}

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
