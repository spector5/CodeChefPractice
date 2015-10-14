package EulerProject;


public class EulerProject6 {

	public static void main(String[] args) {
		int sumOfSquares = 0;
		int squareOfSum = 0;
		int difference = 0;

		for (int i = 0; i <= 100; i++)
			sumOfSquares += (int) Math.pow(i, 2);

		for (int x = 0; x <= 100; x++)
			squareOfSum += x;

		difference = (int) (Math.pow(squareOfSum, 2) - sumOfSquares);
		System.out.println(difference);
	}

}
