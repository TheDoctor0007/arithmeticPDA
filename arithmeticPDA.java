import java.util.Scanner;
import java.util.Stack;

/* PDA for recognising arithmetic expressions
 * 
 * Author: Parth Mistry, prm46
 * 
 */

public class arithmeticPDA {
	static String exp;
	static int i = 0;
	static char c;
	static String ret = "Accepted";
	static Stack st = new Stack();
	static char check;
	
	public static String q0() {
		System.out.println("At state q0");
		c = exp.charAt(i);
		System.out.println("Read: " + c);
		if (c != '$') {
			System.out.println("Crashed");
			return "Rejected";
		}
		System.out.println("Popped: ε");
		st.push(c);
		System.out.println("Pushed: " + c);
		if (i < exp.length()) {
			i++;
			ret = q1();
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		return ret;
	}
	
	public static String q1() {
		System.out.println("At state q1");
		if (i < exp.length()) {
			c = exp.charAt(i);
			System.out.println("Read: " + c);
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		if (c == '(') {
			System.out.println("Popped: ε");
			st.push(c);
			System.out.println("Pushed: " + c);
			if (i < exp.length()) {
				i++;
				ret = q4();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else if (Character.isDigit(c)) {
			System.out.println("Popped: ε");
			System.out.println("Pushed: ε");
			if (i < exp.length()) {
				i++;
				ret = q2();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		return ret;
	}

	public static String q2() {
		System.out.println("At state q2");
		if (i < exp.length()) {
			c = exp.charAt(i);
			System.out.println("Read: " + c);
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		if (Character.isDigit(c)) {
			System.out.println("Popped: ε");
			System.out.println("Pushed: ε");
			if (i < exp.length()) {
				i++;
				ret = q2();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
			System.out.println("Popped: ε");
			System.out.println("Pushed: ε");
			if (i < exp.length()) {
				i++;
				ret = q3();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else if (c == ')') {
			check = (char) st.pop();
			if (check == '(') {
				System.out.println("Popped: " + check);
				System.out.println("Pushed: ε");
				if (i < exp.length()) {
					i++;
					ret = q5();
				} else {
					System.out.println("Crashed");
					return "Rejected";
				}
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else if (c == '$') {
			check = (char) st.pop();
			if (check == '$') {
				System.out.println("Popped: " + check);
				System.out.println("Pushed: ε");
				if (i < exp.length()) {
					i++;
					ret = q6();
				} else {
					System.out.println("Crashed");
					return "Rejected";
				}
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		return ret;
	}
	
	public static String q3() {
		System.out.println("At state q3");
		if (i < exp.length()) {
			c = exp.charAt(i);
			System.out.println("Read: " + c);
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		if (Character.isDigit(c)) {
			System.out.println("Popped: ε");
			System.out.println("Pushed: ε");
			if (i < exp.length()) {
				i++;
				ret = q2();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else if (c == '(') {
			System.out.println("Popped: ε");
			st.push(c);
			System.out.println("Pushed: " + c);
			if (i < exp.length()) {
				i++;
				ret = q4();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		return ret;
	}

	public static String q4() {
		System.out.println("At state q4");
		if (i < exp.length()) {
			c = exp.charAt(i);
			System.out.println("Read: " + c);
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		if (Character.isDigit(c)) {
			System.out.println("Popped: ε");
			System.out.println("Pushed: ε");
			if (i < exp.length()) {
				i++;
				ret = q2();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else if (c == '(') {
			System.out.println("Popped: ε");
			st.push(c);
			System.out.println("Pushed: " + c);
			if (i < exp.length()) {
				i++;
				ret = q4();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		return ret;
	}
	
	public static String q5() {
		System.out.println("At state q5");
		if (i < exp.length()) {
			c = exp.charAt(i);
			System.out.println("Read: " + c);
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
			System.out.println("Popped: ε");
			System.out.println("Pushed: ε");
			if (i < exp.length()) {
				i++;
				ret = q3();
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else if (c == ')') {
			check = (char) st.pop();
			if (check == '(') {
				System.out.println("Popped: " + check);
				System.out.println("Pushed: ε");
				if (i < exp.length()) {
					i++;
					ret = q5();
				} else {
					System.out.println("Crashed");
					return "Rejected";
				}
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else if (c == '$') {
			check = (char) st.pop();
			if (check == '$') {
				System.out.println("Popped: " + check);
				System.out.println("Pushed: ε");
				if (i < exp.length()) {
					i++;
					ret = q6();
				} else {
					System.out.println("Crashed");
					return "Rejected";
				}
			} else {
				System.out.println("Crashed");
				return "Rejected";
			}
		} else {
			System.out.println("Crashed");
			return "Rejected";
		}
		return ret;
	}
	
	public static String q6() {
		System.out.println("At state q6");
		if (i < exp.length()) {
			c = exp.charAt(i);
			System.out.println("Read: " + c);
		}
		if (i != exp.length()) {
			return "Rejected";
		}
		return "Accepted";
	}

	public static void main(String[] args) {
		String confirm;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Would you like to input an arithmetic expression? (y/n)");
			String run = sc.next().toLowerCase();
			if (!run.equals("n") && !run.equals("y")) {
				System.err.println("Unrecognized Input: Please try again.");
				continue;
			}
			else if (run.equals("n")) {
				System.out.println("Goodbye.");
				sc.close();
				System.exit(0);
			}
			else {
				i = 0;
				System.out.println("Please enter an arithmetic expression surrounded by $ (e.g. $2+2$):");
				exp = sc.next();
				System.out.println("Expression input: " + exp);
				confirm = q0();
				System.out.println(confirm);
			}
		}
	}
}
