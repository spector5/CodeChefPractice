package charles.acm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This is problem A for the ACM 2015 regional competition at Radford
 * <h1>Description</h1>
 * <p>
 * Your younger sister is studying for an upcoming standardized test in
 * mathematics, and needs practice with the common style of problem in which the
 * student is presented with a sequence of numbers with one number missing and
 * asked to fill in the missing value.
 * <p>
 * You are aware that the vast majority of these problems feature either
 * arithmetic sequences (where each number in the sentence is formed by adding
 * an integer constant to the prior number) or geometric sequences (where each
 * number in the sequence is formed by multiplying the prior number by an
 * integer constant).
 * <p>
 * Write a program that will help your sister drill on this style of problem by
 * allowing her to check her answers on sample problems
 * <h1>Input</h1>
 * <p>
 * Input will consist of one or more datasets
 * <p>
 * Each dataset will be a single line containing 4 integers defining a sequence.
 * One of these will be {@code -1}, denoting the missing value. The remainder
 * will be positive integers in the range [1,10000]. Other than the {@code -1}
 * placeholder value, the values will be in increasing order.
 * <p>
 * End of input will be signaled by a line containing four {@code -1} values
 * <h1>Output</h1>
 * <p>
 * For each dataset, print one line of output.
 * <p>
 * If a positive integer in the range [1,1000000] exists that can be filled in
 * to the missing value position to create an arithmetic or geometric sequence,
 * print that missing value.
 * <p>
 * If there is no such positive integer, print {@code -1}
 * 
 * @author 5donuts
 *
 */
public class PositiveConSequences {

	/**
	 * This is the main method, where everything exciting happens.
	 * <p>
	 * I probably made this a bit too complicated with all the methods, but I
	 * think it's relatively easy to read and understand
	 * 
	 * @param args
	 *            Command-line arguments, unused
	 * @throws IOException
	 *             from parsing {@code String}s to {@code int}s
	 */
	public static void main(String[] args) throws IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = new String[4]; // array to hold raw input
		int[] array = new int[4]; // array to hold values
		int missingVal, missingIndex; // the missing value

		// actions
		do {
			// read in values
			input = in.readLine().split(" ");

			// parse the values to integers
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(input[i]);
			}

			// find the index of the missing number
			missingIndex = getMissingNumberIndex(array);

			// find missing number
			if (isArithmetic(array, missingIndex)) {
				missingVal = getMissingArithmetic(array, missingIndex);
			} else if (isGeometric(array, missingIndex)) {
				missingVal = getMissingGeometric(array, missingIndex);
			} else { // !isArithmetic && !isGeometric
				missingVal = -1;
			}

			// write value to buffer
			out.write(String.format("%d\n", missingVal));

		} while (inputIsGood(array));

		// flush output buffer
		out.flush();
	}

	/**
	 * This method determines the missing value (or -1 if there is no good
	 * value) for a arithmetic series
	 * 
	 * @param array
	 *            The array to examine
	 * @param missingNumberIndex
	 *            The index of the missing value
	 * @return The value which completes the series or -1 if no integer value
	 *         [1,1000000] will complete the series
	 */
	private static int getMissingArithmetic(int[] array, int missingNumberIndex) {
		// variables
		int val = -1;

		// determine missing value
		if (missingNumberIndex == 0) {
			val = array[2] = array[1];
		} else if (missingNumberIndex == 1) {
			val = array[3] - array[2];
		} else if (missingNumberIndex == 2) {
			val = array[1] - array[0];
		} else {// missingNumberIndex == 3
			val = array[2] - array[1];
		}

		// validate value
		val = (val >= 1 && val <= 1000000) ? val : -1;

		// return value
		return val;
	}

	/**
	 * This method determines the missing value (or -1 if there is no good
	 * value) for a geometric series
	 * 
	 * @param array
	 *            The array to examine
	 * @param missingNumberIndex
	 *            The index of the missing value
	 * @return The value which completes the series or -1 if no integer value
	 *         [1,1000000] will complete the series
	 */
	private static int getMissingGeometric(int[] array, int missingNumberIndex) {
		// variables
		int val = -1;

		// determine missing value
		if (missingNumberIndex == 0) { // TODO handle fraction case
			val = array[2] / array[1];
		} else if (missingNumberIndex == 1) {
			val = array[3] / array[2];
		} else if (missingNumberIndex == 2) {
			val = array[1] / array[0];
		} else {// missingIndex==3
			val = array[1] / array[0];
		}

		// validate value
		val = (val >= 1 && val <= 1000000 && val == (int) Math.floor(val)) ? (int) Math.floor(val) : -1;

		// return value
		return val;
	}

	/**
	 * This method determines the index of the "missing" number (the value -1)
	 * 
	 * @param array
	 *            The array to search
	 * @return The index of the "missing" number (the value -1)
	 */
	private static int getMissingNumberIndex(int[] array) {
		// variables
		int index = -1;

		// determine value
		for (int i = 0; i < array.length; i++) {
			if (array[i] == -1) {
				return i;
			}
		}

		// return value if no index missing
		return index;
	}

	/**
	 * This method determines whether or not the series is arithmetic
	 * 
	 * @param array
	 *            The array to analyze
	 * @param missingIndex
	 *            The index of the missing value
	 * @return Whether or not the series is arithmetic
	 */
	private static boolean isArithmetic(int[] array, int missingIndex) {
		// variables
		boolean isArithmetic;
		int constant;

		// actions
		if (missingIndex == 0) {
			constant = array[2] = array[1];
			isArithmetic = (array[2] + constant == array[3]);
		} else if (missingIndex == 1) {
			constant = array[3] - array[2];
			isArithmetic = (array[0] + (2 * constant) == array[2]);
		} else if (missingIndex == 2) {
			constant = array[1] - array[0];
			isArithmetic = (array[3] == array[1] + (2 * constant));
		} else {// missingIndex == 3
			constant = array[2] - array[1];
			isArithmetic = (array[0] + constant == array[1]);
		}

		// return result
		return isArithmetic;
	}

	/**
	 * This method determines whether or not the series is geometric
	 * 
	 * @param array
	 *            The array to analyze
	 * @param missingIndex
	 *            The index of the missing value
	 * @return Whether or not the series is geometric
	 */
	private static boolean isGeometric(int[] array, int missingIndex) {
		// variables
		boolean isGeometric;
		int constant;

		// actions
		if (missingIndex == 0) {
			constant = array[2] / array[1];
			isGeometric = (array[3] == array[2] * constant);
		} else if (missingIndex == 1) {
			constant = array[3] / array[2];
			isGeometric = (array[0] == array[2] / (int) Math.pow(constant, 2));
		} else if (missingIndex == 2) {
			constant = array[1] / array[0];
			isGeometric = (array[3] == array[1] * (int) Math.pow(constant, 2));
		} else {// missingIndex==3
			constant = array[1] / array[0];
			isGeometric = (array[2] == array[1] * (int) Math.pow(constant, 2));
		}

		// return result
		return isGeometric;
	}

	/**
	 * This method determines if the input is good (there is only one value -1)
	 * or if it is bad (there is more than one value -1)
	 * 
	 * @param array
	 *            The array of integers to search (the input)
	 * @return Whether or not the input is good
	 */
	private static boolean inputIsGood(int[] array) {
		int numNeg = 0;
		for (int element : array) {
			if (element == -1) {
				numNeg++;
			}
		}
		return !(numNeg > 1);
	}
}
