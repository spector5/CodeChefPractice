package acm.competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * This is our solution for problem G from the acm 2015 competition
 * Note: this name is the "is a" from the phrase "The Cake is a lie"
 */
public class isa {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		while (num >= 0) {
			wr.write(doTheThing(num) + "\n");
			num = Integer.parseInt(br.readLine());
		}
		wr.flush();
	}

	public static String getOnes(int num) {
		String word = "" + num;

		switch (num) {
		case 0:
			word = "";
			break;
		case 1:
			word = "one";
			break;
		case 2:
			word = "two";
			break;
		case 3:
			word = "three";
			break;
		case 4:
			word = "four";
			break;
		case 5:
			word = "five";
			break;
		case 6:
			word = "six";
			break;
		case 7:
			word = "seven";
			break;
		case 8:
			word = "eight";
			break;
		case 9:
			word = "nine";
			break;
		}
		return word;
	}

	public static String getTens(int num) {
		String word = "" + num;
		String tens = "";
		if (num >= 20) {
			int second = Integer.parseInt("" + word.charAt(0));
			switch (second) {
			case 2:
				tens = "twenty";
				break;
			case 3:
				tens = "thirty";
				break;
			case 4:
				tens = "forty";
				break;
			case 5:
				tens = "fifty";
				break;
			case 6:
				tens = "sixty";
				break;
			case 7:
				tens = "seventy";
				break;
			case 8:
				tens = "eighty";
				break;
			case 9:
				tens = "ninety";
				break;
			}
			char letter = word.charAt(1);
			String ones = getOnes(Integer.parseInt("" + letter));
			if (!ones.equals(""))
				tens += "-" + ones;
		}

		if (num < 20 && num >= 10) {
			switch (num) {
			case 10:
				tens = "ten";
				break;
			case 11:
				tens = "eleven";
				break;
			case 12:
				tens = "twelve";
				break;
			case 13:
				tens = "thirteen";
				break;
			case 14:
				tens = "fourteen";
				break;
			case 15:
				tens = "fifteen";
				break;
			case 16:
				tens = "sixteen";
				break;
			case 17:
				tens = "seventeen";
				break;
			case 18:
				tens = "eighteen";
				break;
			case 19:
				tens = "nineteen";
				break;
			}
		}

		if (num < 10) {
			char letter = word.charAt(0);
			tens = getOnes(Integer.parseInt("" + letter));
		}
		return tens;
	}

	public static String getHundreds(int num) {
		String word = "" + num;
		String hundreds = "";

		if (num >= 100) {
			hundreds = getOnes(Integer.parseInt("" + word.charAt(0)));
			int single = Integer.parseInt("" + word.charAt(2));
			int two = Integer.parseInt("" + word.charAt(1));
			if (two != 0)
				hundreds += " hundred ";
			else if (single == 0)
				hundreds += " hundred";
			else
				hundreds += " hundred and ";
			String tens = getTens(Integer.parseInt(word.substring(1)));
			hundreds += tens;
		} else if (num >= 10) {
			hundreds = getTens(Integer.parseInt(word));
		} else {
			hundreds = getOnes(Integer.parseInt("" + word.charAt(0)));
		}
		return hundreds;
	}

	public static String doTheThing(int num) {
		String word = "" + num;
		String line = "";
		if (num >= 100000000) {
			String millions = getHundreds(Integer.parseInt(word.substring(0, 3)));
			String thousands = getHundreds(Integer.parseInt(word.substring(3, 6)));
			String hundreds = getHundreds(Integer.parseInt(word.substring(6)));
			if (!thousands.equals(""))
				line = millions + checkMil(num, 3) + thousands + checkThou(num, 6) + hundreds;
			else
				line = millions + checkMil(num, 3) + hundreds;
		} else if (num >= 10000000) {
			String millions = getHundreds(Integer.parseInt(word.substring(0, 2)));
			String thousands = getHundreds(Integer.parseInt(word.substring(2, 5)));
			String hundreds = getHundreds(Integer.parseInt(word.substring(5)));
			if (!thousands.equals(""))
				line = millions + checkMil(num, 2) + thousands + checkThou(num, 5) + hundreds;
			else
				line = millions + checkMil(num, 2) + hundreds;
		} else if (num >= 1000000) {
			String millions = getHundreds(Integer.parseInt(word.substring(0, 1)));
			String thousands = getHundreds(Integer.parseInt(word.substring(1, 4)));
			String hundreds = getHundreds(Integer.parseInt(word.substring(4)));
			if (!thousands.equals(""))
				line = millions + checkMil(num, 1) + thousands + checkThou(num, 4) + hundreds;
			else
				line = millions + checkMil(num, 1) + hundreds;
		} else if (num >= 100000) {
			String thousands = getHundreds(Integer.parseInt(word.substring(0, 3)));
			String hundreds = getHundreds(Integer.parseInt(word.substring(3)));
			line = thousands + checkThou(num, 3) + hundreds;
		} else if (num >= 10000) {
			String thousands = getHundreds(Integer.parseInt(word.substring(0, 2)));
			String hundreds = getHundreds(Integer.parseInt(word.substring(2)));
			line = thousands + checkThou(num, 2) + hundreds;
		} else if (num >= 1000) {
			String thousands = getHundreds(Integer.parseInt(word.substring(0, 1)));
			String hundreds = getHundreds(Integer.parseInt(word.substring(1)));
			line = thousands + checkThou(num, 1) + hundreds;
		} else if (num == 0)
			line = "zero";
		else
			line = getHundreds(Integer.parseInt(word));

		return line;
	}

	public static String checkMil(int num, int start) {
		String word = "" + num;
		word = word.substring(start);
		int boo = Integer.parseInt(word);

		if (boo > 0 && boo < 100)
			return " million and";
		else if (boo > 100)
			return " million, ";
		return " million";
	}

	public static String checkThou(int num, int start) {
		String word = "" + num;
		word = word.substring(start);
		int boo = Integer.parseInt(word);

		if (boo > 0 && boo < 100)
			return " thousand and ";
		else if (boo >= 100)
			return " thousand, ";
		return "thousand";
	}
}
