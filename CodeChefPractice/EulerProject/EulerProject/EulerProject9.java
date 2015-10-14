package EulerProject;

public class EulerProject9 {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int num3 = 1;

		for (num1 = 1; num1 < 1000; num1++)
			for (num2 = 1; num2 < 1000; num2++)
				for (num3 = 1; num3 < 1000; num3++) {
					if ((num1 + num2 + num3) == 1000) {
						int num3Squared = (int) Math.pow(num3, 2);
						if (num3Squared == (int) (Math.pow(num1, 2) + Math.pow(num2, 2))) {
							System.out.println(num1 * num2 * num3);
						}
					}
				}
	}

}
