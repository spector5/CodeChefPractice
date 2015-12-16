package charles.acm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This is problem B from the 2015 acm regional competition. Basically, for this
 * problem you have to find an angle at which to aim a laser using Snell's law.
 * <h1>Description</h1>
 * <p>
 * A submarine is using a communications laser to send a message to a get
 * cruising overhead. The sea surface is flat. The submarine is cruising at a
 * depth {@code d} below the surface. The jet is at height {@code h} above the
 * surface, and a horizontal distance {@code x} from the sub. The submarine
 * turns toward the jet before starting communications, but needs to know the
 * angle of elevation, {@code phi}, at which to aim the laser.
 * </p>
 * <p>
 * When the laser passes from the sea into the air, it is refracted (its path is
 * bent). The refraction is described by Snell's law, which says that light
 * light approaching the horizontal surface at an angle theta_1, measured from
 * the vertical, will leave at an angle theta_2, given by the formula
 * (sin(theta_1)/sin(theta_2))=(n_1/n_2) where n_1 and n_2 are the respective
 * refraction indices of the water and air. (The refraction index of a material
 * is inversely proportional to how fast light can travel through that
 * material.)
 * </p>
 * <h1>Input Description</h1>
 * <p>
 * Input will consist of one or more datasets. Each dataset will consist of one
 * line with 5 floating point numbers. In order:
 * <ul>
 * <li>{@code d} the depth of the submarine (specifically, of the laser emitter)
 * in feet {@code 1 <= d <= 800}
 * <li>{@code h} the height of the plane in feet, {@code 100 <= h <= 10000}
 * <li>{@code x} the horizontal distance from the sub to the plane in feet
 * {@code 0 <= x <= 10000}
 * <li>{@code n_1} the refractive index of water {@code 1.0 < n_1 <= 2.5}
 * <li>{@code n_2} the refractive index of air, {@code 1.0 <= n_2 < n1}
 * </ul>
 * A value of 0 for {@code d} will signal the end of input
 * <h1>Output</h1>
 * <p>
 * For each dataset, print a single line containing the angle of elevation in
 * degrees, to two decimals precision, at which the submarine should aim its
 * laser to illuminate the jet.
 * </p>
 */
public class RefractFacts {

	/**
	 * Entry point for the program; does most of the stuff
	 * 
	 * @param args
	 *            Command-line arguments; unused in this application
	 * @throws NumberFormatException
	 *             From parsing integers & doubles from a {@code BufferedReader}
	 * @throws IOException
	 *             From parsing integers & doubles from a {@code BufferedReader}
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * NOTE: this one doesn't work; this is why you don't do math when
		 * you're tired :/
		 * 
		 */

		// setup
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int d, h, x; // depth, height, horizontal distance
		double n1, n2;// index of water, index of air
		double phi, theta1, theta2; // sub angle, angles for Snell's law
		String[] input = new String[5]; // array for raw input values
		// read input
		input = in.readLine().split(" ");
		// get the input for d
		d = Integer.parseInt(input[0]);
		// ensure data set is good
		while (d > 0) {
			// assign remainder of input to variables
			h = Integer.parseInt(input[1]);
			x = Integer.parseInt(input[2]);
			n1 = Double.parseDouble(input[3]);
			n2 = Double.parseDouble(input[4]);
			// loop through potential phi values
			for (phi = 0.001; phi < 90.000; phi += 0.001) {
				theta1 = 90 - phi;
				theta2 = getTheta2(theta1, n1, n2);
				if (theNumbersWork(theta1, theta2, n1, n2)) {
					out.write(String.format("%.2f", phi));
				} // else, do nothing
			}
			// get new input for d
			input = in.readLine().split(" ");
			d = Integer.parseInt(input[0]);
		}
		// output
		out.flush();
		// cleanup
		out.close();
	}

	/**
	 * Determines whether or not the numbers work NOTE: ANGLES MUST BE IN
	 * RADIANS
	 * 
	 * @param theta1
	 *            One of the angles of refraction for Snell's law
	 * @param theta2
	 *            The other angle of refraction for Snell's law
	 * @param n1
	 *            One of the indices of refraction for Snell's law
	 * @param n2
	 *            The other index of refraction for Snell's law
	 * @return Whether or not Snell's law works with the given numbers
	 */
	public static boolean theNumbersWork(double theta1, double theta2, double n1, double n2) {
		return (Math.sin(theta1) / Math.sin(theta2)) == (n1 / n2);
	}

	/**
	 * Determines the value for {@code theta2} based on other known values NOTE:
	 * ANGLES MUST BE IN RADIANS
	 * 
	 * @param theta1
	 *            The first angle of refraction
	 * @param n1
	 *            The first index of refraction
	 * @param n2
	 *            The second index of refraction
	 * @return The value of {@code theta2} based on the other known values
	 */
	public static double getTheta2(double theta1, double n1, double n2) {
		return Math.asin(Math.sin(theta1) / (n1 / n2));
	}
}
