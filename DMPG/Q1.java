import java.io.BufferedReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Q1 {
	private static Q1 o = new Q1();
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

		int n = in.nextInt();
		int[] arry = new int[n];
		for (int i = 0 ; i< n; i++){
			arry[i] = in.nextInt();
		}
		Arrays.sort(arry);
		int min = Integer.MAX_VALUE;
		for (int i = 0 ; i < arry.length-1; i++){
			if (Math.abs(arry[i]-arry[i+1]) < min){
				min = Math.abs(arry[i]-arry[i+1]);
			}
		}
		System.out.print(min); 
	}
}
