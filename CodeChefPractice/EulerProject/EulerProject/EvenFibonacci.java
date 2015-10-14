package EulerProject;

public class EvenFibonacci {

	public static void main(String[] args) {
		int prev1 = 0;
		int prev2 = 1;
		int total = 0;
		int sum = 0;
		while (true) {
			total = prev1 + prev2;
			if (total > 4000000)
				break;
			else if (total % 2 == 0)
				sum += total;

			prev1 = prev2;
			prev2 = total;
		}

		System.out.println(sum);
	}
}
