package srok.test.programmers;


public class GetMiddleLetter {
	public static void main(String[] args) {
		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));
	}

	public static String solution(String s) {
        String answer = "";
        int mid = s.length();
        if(mid % 2 == 0) {
        	answer = s.substring(mid/2 - 1, mid/2 + 1);
        }else {
        	answer = s.substring(mid/2, mid/2 + 1);
        }
        return answer;
    }
}