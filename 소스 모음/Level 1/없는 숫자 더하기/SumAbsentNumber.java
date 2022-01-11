package srok.test.programmers;

public class SumAbsentNumber {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,4,6,7,8,0}));	//14
		System.out.println(solution(new int[] {5,8,4,0,6,7,9}));	//6
	}

	public static int solution(int[] numbers) {
        int answer = -1;
        answer = 45;
        for(int i : numbers) {
        	answer -= i;
        }
        
        return answer;
    }
}