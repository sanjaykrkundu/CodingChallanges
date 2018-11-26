package geHealthcare;

public class PalindromeCut {

	static boolean pal[][];

	static void countPS(String str, int n) {
		pal = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				pal[i][j] = isPal(str.substring(i, j), j - 1);
			}
		}
	}

	public static boolean isPal(String str) {
		return isPal(str, str.length());
		
		//boolean r= isPal(str, str.length());
		//System.out.println(str + "\t" + r);
		//return r;
	}

	public static boolean isPal(String str, int n) {
		for (int i = 0; i < (n / 2); ++i) {
			if (str.charAt(i) != str.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}

	static int count = 0;

	static void printSubString(String str, int len, int cut) {
		if (n - k < len || cut < 0 || str.length() < len + cut)
			return;

		if (cut > 0)
			System.out.printf("%5s %d %d\t-> %s\n", str, len, cut, str.substring(0, len));
		else {
			System.out.printf("%5s %d %d\t-> %s\n", str, len, cut, str.substring(0));
			return;
		}
		printSubString(str.substring(len), 1, cut - 1);
		printSubString(str, len + 1, cut);
	}

	static int subString(String str, int len, int cut) {
		if (n - k < len || cut < 0 || str.length() < len + cut)
			return 0;
		if (cut == 0) {
			System.out.println(str.substring(0));
			if (isPal(str.substring(0)))
				return 1;
			else
				return 0;
		}
		System.out.println(str.substring(0,len));
		int xx = subString(str.substring(len), 1, cut - 1) + subString(str, len + 1, cut);
		
		if(isPal(str.substring(0, len)))
			return xx+1;
		else 
			return xx;
	}

	static int n, k;

	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(System.in);
		n = 5;
		k = 2;
		String str = "aabbc";
		/*
		 * n = sc.nextInt(); k = sc.nextInt(); str = sc.nextLine(); sc.close();
		 * 
		 */
		count = subString(str, 1, k);
		System.out.println(count);
		
		
		isPal("a");
		isPal("a");
		isPal("bbc");
		isPal("ab");
		isPal("bc");
		isPal("abb");
		isPal("c");
		isPal("aa");
		isPal("b");
		isPal("bc");
		isPal("bb");
		isPal("c");
		isPal("aab");
		isPal("b");
		isPal("c");
	}
}
