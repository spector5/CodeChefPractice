package acm.competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class isav2 {

	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		while (num > 0) {
			System.out.println(doTheThing(num));
			num = Integer.parseInt(br.readLine());
		}

	}

	public static String getOnes(int num) {
		String word = "";
		switch (num) {
		case 0:
			return "";
		case 1:
			return "one ";
		case 2:
			return "two ";
		case 3:
			return "three ";
		case 4:
			return "four ";
		case 5:
			return "five ";
		case 6:
			return "six ";
		case 7:
			return "seven ";
		case 8:
			return "eight ";
		case 9:
			return "nine ";

		}
		
		return word;
	}

	public static String getTens(int num)
	{
		String tens = "";
		if(num >= 20)
		{
			int tensPlace = num / 10;

			switch (tensPlace) {
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

			String ones = getOnes(num % 10);
			if(!ones.equals(""))
				tens += "-" + ones;
			else
				tens += " ";

		}
		else if(num >= 10 && num < 20)
		{
			switch (num) {
			case 10:
				tens = "ten ";
				break;
			case 11:
				tens = "eleven ";
				break;
			case 12:
				tens = "twelve ";
				break;
			case 13:
				tens = "thirteen ";
				break;
			case 14:
				tens = "fourteen ";
				break;
			case 15:
				tens = "fifteen ";
				break;
			case 16:
				tens = "sixteen ";
				break;
			case 17:
				tens = "seventeen ";
				break;
			case 18:
				tens = "eighteen ";
				break;
			case 19:
				tens = "nineteen ";
				break;
			}
		}
		else
			tens = getOnes(num);

		return tens;
	}

	public static String getHundreds(int num)
	{
		String word = "";
		if(num >= 100)
		{
			String hundreds = getOnes(Integer.parseInt(("" + num).substring(0, 1)));
			String tens = getTens(num % 100);
			int tensPlace = num % 100;
			if(tensPlace < 10 && tensPlace > 0)
				word = hundreds + "hundred and " + tens;
			else
				word = hundreds + "hundred " + tens;
		}
		else
			word = getTens(num);

		return word;
	}

	public static String doTheThing(int num) 
	{
		String number = "";
		int mNum = num / 1000000;
		int tNum = (num % 1000000)/1000;
		int hNum = num % 1000;
		String millions = "";
		String thousands = "";
		String hundreds = "";
		
		if(num == 0)
		{
			return "zero";
		}
		else if(num < 1000)
		{
			number = getHundreds(num);
		}
		else if(num < 1000000)
		{
			thousands = getHundreds(tNum);
			hundreds = getHundreds(hNum);
			
			if(hNum == 0)
				number = thousands + "thousand";
			else if(hNum < 100)
				number = thousands + "thousand and " + hundreds;
			else
				number = thousands + "thousand, " + hundreds;
				
		}
		else
		{
			millions = getHundreds(mNum);
			thousands = getHundreds(tNum);
			hundreds = getHundreds(hNum);
			
			int tH = (tNum * 1000) + hNum;
			
			if(tNum > 0)
			{
				if(hNum == 0)
					number += thousands + "thousand";
				else if(hNum < 100)
					number += thousands + "thousand and " + hundreds;
				else
					number += thousands + "thousand, " + hundreds;
			}
			
			if(tH == 0)
				number = millions +  "million";
			else if(tH < 100)
				number = millions + "million and " + hundreds;
			else
				number = millions + "million, ";
			
			if(tNum > 0)
			{
				if(hNum == 0)
					number += thousands + "thousand";
				else if(hNum < 100)
					number += thousands + "thousand and " + hundreds;
				else
					number += thousands + "thousand, " + hundreds;
			}
			
		}
		
		return number;
	}
	

}
