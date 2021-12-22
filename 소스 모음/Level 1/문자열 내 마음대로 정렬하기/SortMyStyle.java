package srok.test.programmers;

import java.util.Arrays;

public class SortMyStyle {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"sun", "bed", "car"}, 1)));
		System.out.println(Arrays.toString(solution(new String[] {"abce", "abcd", "cdx"}, 2)));
	}

	public static String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings);
        Arrays.asList(strings).sort((a,b)->{
        	return a.charAt(n) - b.charAt(n); 
        });
        
        answer = strings;
        return answer;
    }
}