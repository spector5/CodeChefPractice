package charles.acm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This is the practice problem for the 2015 acm regionals competition.
 * Basically, for this practice problem you are given the weight of objects on
 * earth and have to convert to the weight on the moon
 * <h1>Description</h1>
 * <p>
 * After several months struggling with a diet, Jack has become obsessed with
 * the idea of weighing less. In an odd way, he finds it very comforting to
 * think that, if he had simply had the luck to be born on a different planet,
 * his weight could be considerably less.
 * </p>
 * <p>
 * Of course, the planets are far out of reach, but even the Earth's moon would
 * yield a dramatic weight loss. Objects on the moon weight only 0.167 of their
 * weight on Earth.
 * </p>
 * <h1>Input Description</h1>
 * <p>
 * Input consists of one or more lines, each containing a single floating point
 * number denoting a weight (in pounds) on the Earth. The end of input is
 * denoted by a negative floating point number
 * </p>
 * <h1>Output Description</h1>
 * <p>
 * For each line of input data, your program should print a single line of the
 * form {@code X Y} where {@code X} is the weight from the input and {@code Y}
 * is the corresponding weight on the moon. Both output numbers should be
 * printed to a precision of 2 digits after the decimal point. The numbers
 * should be separated on the line by a single blank.
 * </p>
 */
public class Lunacy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		double earthWeight, moonWeight; // the weights for the earth & moon
		// actions
		// get the input
		earthWeight = Double.parseDouble(in.readLine());
		while (earthWeight >= 0) {
			// convert from earth to moon weight
			moonWeight = earthWeight * 0.167;
			// write to buffer
			out.write(String.format("%.2f %.2f\n", earthWeight, moonWeight));
			// update loop w/more input
			earthWeight = Double.parseDouble(in.readLine());
		}
		// output
		out.flush();
		// cleanup
		out.close();
	}
}
