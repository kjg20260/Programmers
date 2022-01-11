package srok.test.programmers;

import java.util.Arrays;

public class Remainder1 {
	public static void main(String[] args) {
		System.out.println(solution(10));	//3
		System.out.println(solution(12));	//11
	}
	
	public  static int solution(int n) {
        int answer = 0;
        n--;
        for(int i = 2; i <= n; i++) {
        	if(n%i == 0) {
        		answer = i;
        		break;
        	}
        }
        return answer;
    }
}
