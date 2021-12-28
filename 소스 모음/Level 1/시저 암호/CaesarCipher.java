package srok.test.programmers;

public class CaesarCipher {
	public static void main(String[] args) {
		System.out.println(solution("AB",1));
		System.out.println(solution("z",1));
		System.out.println(solution("a B z",4));
	}

	public static String solution(String s, int n) {
        String answer = "";
        
        for(String str : s.split("")) {
        	int ascii = str.hashCode();
        	String temp = str;
        	if(ascii >= 97 && ascii <= 122) {
        		temp = String.format("%c", ((ascii + n - 97 ) % 26 + 97));        		
        	}else if(ascii >= 65 && ascii <= 90) {
        		temp = String.format("%c", ((ascii + n - 65 ) % 26 + 65));        		
        	}
        	answer += temp;
        }
        
        return answer;
    }
}