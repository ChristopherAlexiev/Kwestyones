package questions;

import java.io.BufferedReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class QQ2 {
	private static QQ2 o = new QQ2();
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
		/*
		int F = in.nextInt();
		int N = in.nextInt();
		long[] prices = new long[F];
		for (int i = 0; i < prices.length; i++){
			prices[i]=in.nextLong();
		}
		
		Arrays.sort(prices);
		
		long price = 0;
		long exponent = 1;
		for (int i = N-1; i>=0;i--){
			//price += Math.pow(prices[i],exponent);
			long number = 1;
			for (int k = 0 ; k < exponent ; k++){
				number *=prices[i];
			}
			price += number;
			price = price%1000000007;
			exponent++;
		}
		
		System.out.print((int)(price));
		*/
		int F = in.nextInt();
		int N = in.nextInt();
		ArrayList<Integer> listy = new ArrayList<Integer>(); 
		for (int i = 0; i < F; i++){
			listy.add(in.nextInt());
		}
		
		Collections.sort(listy);
		
		long price = 0;
		int exponent = 1;
		for (int i = N-1; i>=0;i--){
			//price += Math.pow(listy.get(i),exponent)%1000000007;
			BigInteger t = new BigInteger("1");
			long number = 1;
			BigInteger pricey = new BigInteger(Integer.toString(listy.get(i)));
			for (int k = 0 ; k < exponent ; k++){
				t = t.multiply(pricey);
			//	number = number%1000000007;
			}
			BigInteger mody = new BigInteger("1000000007");
			t = t.mod(mody);
			int tInt = t.intValue();
			price += tInt;
			price = price%1000000007;
			exponent++;
		}
		
		System.out.print((int)(price));
	}
}
