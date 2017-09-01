import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Q6 {
	private static Q6 o = new Q6();

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

		int length = in.nextInt();
		int changes = in.nextInt();

		String stringy = in.next();
		String newString = "";

		int numChanges = 0;
		Stack<String> stacky = new Stack<String>();
		boolean bigExit = false;
		while (true) {
			for (int i = 0; i < length; i++) {

				String current = stringy.substring(i, i + 1);
				if (numChanges < changes) {
					if (stacky.isEmpty()) {
						if (current.equals("}") || current.equals(")") || current.equals("]")) {
							System.out.println("impossible");
							bigExit = true;
							break;
						}
						stacky.push(current);
						newString += current;
					} else if ((stacky.peek().equals("(") || stacky.peek().equals("{") || stacky.peek().equals("["))
							&& (current.equals("{") || current.equals("(") || current.equals("["))) {
						stacky.push(current);
						newString += current;
					} else if (stacky.peek().equals("{") && (current.equals(")") || current.equals("]"))) {
						newString += "}";
						stacky.pop();
						numChanges++;
					} else if (stacky.peek().equals("{") && current.equals("}")) {
						stacky.pop();
						newString += current;
					} else if (stacky.peek().equals("(") && (current.equals("}") || current.equals("]"))) {
						newString += ")";
						stacky.pop();
						numChanges++;
					} else if (stacky.peek().equals("(") && current.equals(")")) {
						stacky.pop();
						newString += current;
					} else if (stacky.peek().equals("[") && (current.equals(")") || current.equals("}"))) {
						newString += "]";
						stacky.pop();
						numChanges++;
					} else if (stacky.peek().equals("[") && current.equals("]")) {
						stacky.pop();
						newString += current;
					}
				} else {
					newString += current;
				}
			}
			if (bigExit == true) {
				break;
			}

			if (!stacky.isEmpty()) {
				System.out.println("impossible");
				break;
			}

			// add extra spots from brackets originally the same type (2 changes
			// per turn)
			if (numChanges < (changes - 1)) {
				for (int i = 0; i < newString.length(); i++) {
					int start = i;
					int end = -1;
					String current = newString.substring(i, i + 1);
					Stack<String> newTestStack = new Stack<String>();
					if (current.equals("{") || current.equals("(") || current.equals("{")) {
						newTestStack.push(current);
						for (int j = i + 1; j < newString.length(); j++) {
							String bracket = newString.substring(j, j + 1);
							if (bracket.equals("}") || bracket.equals(")") || bracket.equals("}")) {
								newTestStack.pop();
							} else {
								newTestStack.push(bracket);
							}
							if (newTestStack.isEmpty()) {
								end = j;
								break;
							}
						}
						/// make different
						// if originally the pair of brackets were the same type
						if (((stringy.substring(start, start + 1).equals("[")
								|| stringy.substring(start, start + 1).equals("]"))
								&& (stringy.substring(end, end + 1).equals("[")
										|| stringy.substring(end, end + 1).equals("]")))
								|| ((stringy.substring(start, start + 1).equals("{")
										|| stringy.substring(start, start + 1).equals("}"))
										&& (stringy.substring(end, end + 1).equals("{")
												|| stringy.substring(end, end + 1).equals("}")))
								|| ((stringy.substring(start, start + 1).equals("(")
										|| stringy.substring(start, start + 1).equals(")"))
										&& (stringy.substring(end, end + 1).equals("(")
												|| stringy.substring(end, end + 1).equals(")")))) {
							if (stringy.substring(start, start + 1).equals("(")) {
								newString = newString.substring(0, start) + "[" + newString.substring(start + 1, end)
										+ "]" + newString.substring(end + 1);
							} else {
								newString = newString.substring(0, start) + "(" + newString.substring(start + 1, end)
										+ ")" + newString.substring(end + 1);
							}
							numChanges += 2;
						}

					}

					if (numChanges >= (changes - 1)) {
						break;
					}
				}

			}

			// add extra changes from brackets that were originally different (1
			// change per turn (the other change addition would have been in
			// original program)
			if (numChanges < changes) {
				for (int i = 0; i < newString.length(); i++) {
					int start = i;
					int end = -1;
					String current = newString.substring(i, i + 1);
					Stack<String> newTestStack = new Stack<String>();
					if (current.equals("{") || current.equals("(") || current.equals("{")) {
						newTestStack.push(current);
						for (int j = i + 1; j < newString.length(); j++) {
							String bracket = newString.substring(j, j + 1);
							if (bracket.equals("}") || bracket.equals(")") || bracket.equals("}")) {
								newTestStack.pop();
							} else {
								newTestStack.push(bracket);
							}
							if (newTestStack.isEmpty()) {
								end = j;
								break;
							}
						}
						/// make different
						// if originally the brackets were not the same type
						if (!(((stringy.substring(start, start + 1).equals("[")
								|| stringy.substring(start, start + 1).equals("]"))
								&& (stringy.substring(end, end + 1).equals("[")
										|| stringy.substring(end, end + 1).equals("]")))
								|| ((stringy.substring(start, start + 1).equals("{")
										|| stringy.substring(start, start + 1).equals("}"))
										&& (stringy.substring(end, end + 1).equals("{")
												|| stringy.substring(end, end + 1).equals("}")))
								|| ((stringy.substring(start, start + 1).equals("(")
										|| stringy.substring(start, start + 1).equals(")"))
										&& (stringy.substring(end, end + 1).equals("(")
												|| stringy.substring(end, end + 1).equals(")"))))) {

							if ((!stringy.substring(start, start + 1).equals("{")
									&& !stringy.substring(end, end + 1).equals("{")
									&& !stringy.substring(start, start + 1).equals("}")
									&& !stringy.substring(end, end + 1).equals("}"))) {
								newString = newString.substring(0, start) + "{" + newString.substring(start + 1, end)
										+ "}" + newString.substring(end + 1);
							} else if ((!stringy.substring(start, start + 1).equals("[")
									&& !stringy.substring(end, end + 1).equals("[")
									&& !stringy.substring(start, start + 1).equals("]")
									&& !stringy.substring(end, end + 1).equals("]"))) {
								newString = newString.substring(0, start) + "{" + newString.substring(start + 1, end)
										+ "}" + newString.substring(end + 1);
							} else if ((!stringy.substring(start, start + 1).equals("(")
									&& !stringy.substring(end, end + 1).equals("(")
									&& !stringy.substring(start, start + 1).equals(")")
									&& !stringy.substring(end, end + 1).equals(")"))) {
								newString = newString.substring(0, start) + "[" + newString.substring(start + 1, end)
										+ "]" + newString.substring(end + 1);
							}
							numChanges++;

						}

					}

					if (numChanges == changes) {
						break;
					}
				}

			}

			if (numChanges < changes){
				System.out.println("impossible");
				break;
			}
			
			System.out.println(newString);

			break;
		}
	}
}
