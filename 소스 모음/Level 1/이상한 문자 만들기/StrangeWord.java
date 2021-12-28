package srok.test.programmers;

public class StrangeWord {
	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
	}

	public static String solution(String s) {
		String answer = "";
		Boolean up = true;
		
		for(String str : s.split("")) {
			if(str.equals(" ")) {
				answer += str;
				up = true;
			}else {
				if(up) {
					answer += str.toUpperCase();
					up = false;
				}else {
					answer += str.toLowerCase();
					up = true;
				}
			}
		}
		return answer;
	}
}