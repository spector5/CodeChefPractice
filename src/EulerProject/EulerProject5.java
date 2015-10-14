package EulerProject;


public class EulerProject5 {

	public static void main(String[] args) {
		int num = 21;
		while (true) {
			if (divisible(num))
				break;
			num++;
		}
		System.out.println(num);
	}

	public static boolean divisible(int num) {
		for (int i = 1; i <= 20; i++) {
			if (num % i != 0)
				return false;
		}
		return true;
	}

}
