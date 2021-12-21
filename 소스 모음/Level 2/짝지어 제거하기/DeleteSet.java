package srok.test.programmers;

import java.util.Stack;

public class DeleteSet {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("cdcd"));
	}

	public static int solution(String s) {
		Stack<String> stack = new Stack<String>();
		
		String[] sArray = s.split("");
		for(String str : sArray) {
			if(stack.size() > 0) {
				String target = stack.peek();
				if(!target.equals(str)) {
					stack.push(str);
				} else {
					stack.pop();
				}
			} else {
				stack.push(str);
			}
		}
		
		return stack.size() == 0 ? 1 : 0;
	}
}