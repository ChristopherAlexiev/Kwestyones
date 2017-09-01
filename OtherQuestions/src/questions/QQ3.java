package questions;

import java.io.BufferedReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class QQ3 {
	private static QQ3 o = new QQ3();

	public class Reader {
		private BufferedReader in;
		private StringTokenizer st;

		public Reader(InputStream inputStream) {
			in = new BufferedReader(new InputStreamReader(inputStream));
		} // Reader InputStream constructor

		public Reader(String fileName) throws FileNotFoundException {
			in = new BufferedReader(new FileReader(fileName));
		} // Reader String constructor

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(in.readLine().trim());
			} // while
			return st.nextToken();
		} // next method

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		} // nextLong method

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		} // nextInt method

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		} // nextDouble method

		public String nextLine() throws IOException {
			return in.readLine().trim();
		} // nextLine method
	} // Reader class

	private static Reader in = o.new Reader(System.in);

	public static void main(String[] args) throws IOException {
		int F = in.nextInt();
		int[] woods = new int[F];
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		HashSet<Integer> hashSety = new HashSet<Integer>();
		int maxLength = 0;
		int occurrences = 0;
		
		for (int i = 0; i < F; i++) {
			woods[i] = in.nextInt();
		}
		Arrays.sort(woods);
		
		for (int i = 0; i < woods.length - 1; i++) {
			for (int j = i + 1; j < woods.length; j++) {
				int sum = woods[i]+woods[j];
				if (!hashSety.contains(sum)){//check if must be wrapped
					hashSety.add(sum);
					int length = getLength(i, j, woods);
					if (length == maxLength){
						occurrences++;
					} else if (length > maxLength){
						maxLength = length;
						occurrences = 1;
					}
				}
			}
		}

		System.out.print(maxLength + " " + occurrences);

	}

	static int getLength(int i, int j, int[] woods) {
		int sum = woods[i]+woods[j];
		int length = 1;
		
		if (j-i > 2){
			i++;
			j--;
		} else {
			return length;
		}
		
		while (true){
			if (woods[j]+woods[i]>sum){
				if (j-i > 1){
					j--;
				} else {
					return length;
				}
			} else if (woods[j]+woods[i]<sum){
				if (j-i > 1){
					i++;
				} else {
					return length;
				}
			} else if (woods[j]+woods[i]==sum){
				length++;
				if (j-i > 2){
					i++;
					j--;
				} else {
					return length;
				}
			}
		}
	}
}

