package srok.test.programmers;

public class CorrectParenthesis {
	public static void main(String[] args) {
		System.out.println(solution("()()")); 	// true
		System.out.println(solution("(())()")); // true
		System.out.println(solution(")()(")); 	// false
		System.out.println(solution("(()(")); 	// false
	}

	public static boolean solution(String s) {
		int a = 0;
		for (int idx = 0; idx < s.length(); idx++) {
			if(s.charAt(idx) == ')') {
				a--;
			} else if(a < 0) {
				break;
			} else {
				a++;
			}
		}
		return a == 0;
	}
}