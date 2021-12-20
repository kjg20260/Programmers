package srok.test.programmers;

import java.util.Arrays;

public class TargetNumber {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,1,1,1,1},3));
	}

	public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = calc(numbers, 0, target);
        return answer;
    }
	
	private static int calc(int[] numbers, int val, int target) {
		int result = 0;
		int plus = val + numbers[0];
		int minus = val - numbers[0];
		numbers = Arrays.copyOfRange(numbers, 1, numbers.length);
		if(numbers.length == 0) {
			if(plus == target || minus == target)
				result++;
			return result;
		} else {
			result += calc(numbers, plus, target);
			result += calc(numbers, minus, target);
		}
		return result;
	}
}