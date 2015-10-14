package EulerProject;

public class EulerProject12 {

	public static void main(String[] args) {
		int divisors;
		int triangle = 0;
		int i = 1;
		while (true) {
			triangle += i++;
			divisors = 1;
			for (int x = 1; x <= (triangle / 2); x++) {
				if (triangle % x == 0)
					divisors++;
			}

			if (divisors > 500)
				break;
		}

		System.out.println(triangle);
	}

}
