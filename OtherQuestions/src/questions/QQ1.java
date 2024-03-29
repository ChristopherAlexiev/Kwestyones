package questions;


import java.io.BufferedReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class QQ1 {
	private static QQ1 o = new QQ1();
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
		
		
		int num = in.nextInt();
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = 0; i< num; i++){
	
			int N = in.nextInt();
			int K = in.nextInt();
			
			int number = N-K;
			
			int j = 1;
			int lastNum = 1;
			int currentNum = 1;
			while (true){
				if (j != 1){
					lastNum = currentNum;
					currentNum = (j*(j+1)/2 + lastNum);
					
					if (currentNum > number){
						System.out.println(lastNum);
						break;
					}
				} else {
					lastNum = 1;

				}
				j++;
			}
			
		
		}
	}
}

