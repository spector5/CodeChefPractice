/**
 * @url https://icpcarchive.ecs.baylor.edu/external/71/7117.pdf
 */
package Trevor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HyphenationRulez {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while(!(line = br.readLine()).equals("===")) //reading all lines until i recieve the termination line
		{
			String[] words = line.split(" "); //all of the words on the line
			for(int x = 0; x < words.length; x++)
			{
				String word = words[x];
				int wordLength = word.length();
				for(int i = 0; i < wordLength; i++) //for each letter in the word
				{
					char letter = word.charAt(i);
					if(isVowel(letter))//all of the things we are looking for start with a vowel
					{
						//num is the number to add to i to get to the next uncheckeed
						//for instance if the word was dastred num would be 4 since
						//i would equal 1 when it hits the a, str counts as 1 consonant and the next position to check
						//would be the e at postion 5 so you would have 1 + 4 = 5
						int num = isConsonant(word, i);
						if(num == -1)
							continue;
						else //must be consonant, check if next position is a vowel
						{
							if((i + num) < word.length() && isVowel(word.charAt(i+num))) //Determines if we have a vowel consonant vowel structure
							{
								if(!(word.charAt(i + num) == 'e' && i + num == word.length() -1)) //Looks for an e at the end of the word 
								{																//Ex. technique is tech-nique since the e at the ends prevents the hyphenization
									word = word.substring(0, i+1) + "-" + word.substring(i+1, word.length()); //add the hyphenation
									wordLength++;
								}
							}
							else if((i + num) < word.length())//check for vowel consonant, consonant, vowel
							{
								//sorry for all of the -1, due to how i set up isConstant, i had to add them due to some off by 1 errors
								int num2 = isConsonant(word, i + num - 1);
									if((i + num + num2 - 1) < word.length())
										if(isVowel(word.charAt(i+num+num2 - 1))) //looking for v,c,c,v pattern
										{
											word = word.substring(0, i+num) + "-" + word.substring(i+num, word.length());
											wordLength++;
										}
							}
						}
					}
				}
				
				words[x] = word;
			}
			
			for(String word : words)
				System.out.println(word);
		}
	}

	public static boolean isVowel(char letter) //Checking for vowel
	{
		letter = Character.toLowerCase(letter);
		if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' ||letter == 'u' || letter == 'y')
			return true;

		return false;
	}

	public static int isConsonant(String word, int i)
	{
		if(i + 1 < word.length())
		{
			char letter = Character.toLowerCase(word.charAt(i + 1));
			if(isVowel(letter)) //Make sure it isnt a vowel
				return -1;
			switch (letter) //Check for all the things it asks
			{
			case 'q':
				if(i + 2 < word.length())
					if(word.charAt(i + 2) == 'u')
						return 3;
				return 2;
			case 't':
				if(i + 2 < word.length())
					if(word.charAt(i + 2) == 'r')
						return 3;
				return 2;
			case 'b':
				if(i + 2 < word.length())
					if(word.charAt(i + 2) == 'r' || word.charAt(i + 2) == 'l')
						return 3;
				return 2;
			case 's':
				if(i + 2 < word.length())
					if(word.charAt(i + 2) == 't' || word.charAt(i + 2) == 'l')
					{
						if(i + 3 < word.length())
							if(word.charAt(i + 3) == 'r')
								return 4;
						return 3;
					}		
				return 2;
			case 'c':
				if(i + 2 < word.length())
					if(word.charAt(i + 2) == 'r' || word.charAt(i + 2) == 'h')
						return 3;
				return 2;
			case 'p':
				if(i + 2 < word.length())
					if(word.charAt(i + 2) == 'h')
						return 3;
				return 2;
			default:
				return 2;
			}
		}
		return -1;
	}

}
