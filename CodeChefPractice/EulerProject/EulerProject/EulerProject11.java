package EulerProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EulerProject11 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Hulk\\EclipseWorkSpace\\git\\CodeChef\\Test\\src\\Euler11.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		int[][] a = new int[20][20];

		for (int i = 0; i < 20; i++) {
			String[] line = br.readLine().split(" ");
			for (int x = 0; x < 20; x++)
				a[i][x] = Integer.parseInt(line[x]);
		}

		int max = 0;
		for (int i = 0; i < 20; i++) {
			for (int x = 0; x < 20; x++) {
				int[] product = new int[4];
				if (i + 3 < 20) // check down
					product[0] = a[i][x] * a[i + 1][x] * a[i + 2][x] * a[i + 3][x];

				if (i + 3 < 20 && x + 3 < 20) // check down diagonal
					product[1] = a[i][x] * a[i + 1][x + 1] * a[i + 2][x + 2] * a[i + 3][x + 3];

				if (x + 3 < 20)
					product[2] = a[i][x] * a[i][x + 1] * a[i][x + 2] * a[i][x + 3];

				if (i - 3 >= 0 && x + 3 < 20)
					product[3] = a[i][x] * a[i - 1][x + 1] * a[i - 2][x + 2] * a[i - 3][x + 3];

				for (int num : product) {
					if (num > max)
						max = num;
				}
			}
		}
		System.out.println(max);
	}

}
