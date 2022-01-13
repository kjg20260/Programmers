package srok.test.programmers;

import java.util.Arrays;
import java.util.ArrayList;

public class LinuUp {
	public static void main(String[] args) {
//		System.out.println(Arrays.toString(solution(4, 5)));
		System.out.println(Arrays.toString(solution(20, 50000000)));
	}
	
	//list에서 인덱스가 나머지 나누기 (n-1)!인 값을 각각 구하면 된다
	public static int[] solution(int n, long k) {
		int[] answer = new int[n];
		int direction = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		long q = 0;
		long r = k-1;
		long factorial = 1;	 
		
		for(int idx=1; idx <= n && idx > 0;) {
			if(direction > 0) {
				factorial *= idx;
				list.add(idx);
			} else {
				q = r / factorial;
				r = r % factorial;
				answer[n-idx-1] = list.remove((int)(q));
				factorial /= idx;
			}
			if(idx == n) {
				direction = -direction;
				factorial /= idx;
			}

			idx += direction;
		}
		answer[answer.length-1] = list.get(0);
		return answer;
	}
}
