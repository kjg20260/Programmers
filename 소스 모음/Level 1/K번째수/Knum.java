package srok.test.programmers;

import java.util.Arrays;

public class Knum {
	public static void main(String[] args) {
//		System.out.println(solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
		for(int i :solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerNum = 0;
        for(int[] iArray : commands) {
        	int[] test = Arrays.copyOfRange(array, iArray[0]-1, iArray[1]);
        	int t = 101;
        	for(int i = 0; i<iArray[2];i++) {
        		for(int j = i ; j < test.length; j++) {
        			if(j == i ) {
        				t = test[j];
        			}else 
        				if(test[i] >= test[j]) {
        				t = test[j];
        				test[j] = test[i];
        				test[i] = t;
        			}
        		}
        	}
        	answer[answerNum] = t;
        	answerNum++;
        }
        return answer;
    }
}