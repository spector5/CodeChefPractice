package Wesley;
import java.util.Scanner;
import java.text.DecimalFormat;
public class totalExpenses {
	public static void main(String[] args){
		DecimalFormat df = new DecimalFormat("#.00");
		double total = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of test cases.");
		double testCases = scan.nextDouble();
		while(testCases > 0){
			System.out.print("Enter the quantity.");
			double quantity = scan.nextDouble();
			System.out.print("Enter the price per unit.");
			double price = scan.nextDouble();
			if(quantity <= 1000)
				total = price * quantity;
			else{
				total = price * quantity;
				total = (total - (total * .10));
			}
			System.out.println("$" + df.format(total));
			testCases--;
		}
	}
}
