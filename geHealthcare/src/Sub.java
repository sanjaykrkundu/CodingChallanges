package geHealthcare;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Sub {

	static int tc, j, k, len, range, temp;
	static int lt[][];
	static String str;

	public static void dodp() {
		for (int i = 0; i < len; i++) {
			lt[i][i] = 1;
		}

		for (int k = 1; k < len; k++) {
			lt[k][k - 1] = 1;
		}

		for (int m = 1; m < len; m++) {
			for (int row = 0; row < len - m; row++) {
				int col = row + m;

				if (str.charAt(row) != str.charAt(col)) {
					lt[row][col] = 0;
				} else {
					if (lt[row + 1][col - 1] == 1)
						lt[row][col] = 1;
					else
						lt[row][col] = 0;
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		tc = Integer.valueOf(s);

		for (int i = 0; i < tc; i++) {
			str = br.readLine();
			len = str.length();
			lt = new int[len][len];
			dodp();

			if (lt[0][len - 1] == 1) {
				System.out.println("YES");
				continue;
			}

			range = 0;
			temp = len / 2;
			j = 0;
			k = len - 1;

			while (j != temp && k != temp) {
				range += 2;
				if (lt[0][range - 1] == 1) {
					if (lt[range][len - 1] == 1) {
						System.out.println("YES");
						break;
					}
				}
				if (lt[len - range][len - 1] == 1) {
					if (lt[0][len - range - 1] == 1) {
						System.out.println("YES");
						break;
					}
				}
				j++;
				k--;
			}

			if (j == temp || k == temp)
				System.out.println("NO");

		}
	}
}