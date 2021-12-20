package srok.test.programmers;

public class Weekly1 {
	public static void main(String[] args) {
		System.out.println(solution(2500,45,2500));
	}

	public static long solution(int price, int money, int count) {
        long answer = -1;
        answer = (long)price * ((long)count * (long)(count+1))/2 - money;
        return answer > 0 ? answer : 0;
    }
}