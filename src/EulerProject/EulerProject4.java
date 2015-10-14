package EulerProject;


public class EulerProject4 {

	public static void main(String[] args) {
		int num1;
		int num2;
		int total = 0;
		int maxPal = 0;
		for (num1 = 999; num1 >= 100; num1--) {
			for (num2 = num1; num2 >= 100; num2--) {
				total = num1 * num2;
				if (isPalindrome((total)))
					if (total > maxPal)
						maxPal = total;

			}
		}

		System.out.println(maxPal);

	}

	public static boolean isPalindrome(int num) {
		String strNum = "" + num;
		int l = 0;
		int r = strNum.length() - 1;

		while (l < r) {
			if (strNum.charAt(l) != strNum.charAt(r))
				return false;
			l++;
			r--;
		}

		return true;
	}

}
