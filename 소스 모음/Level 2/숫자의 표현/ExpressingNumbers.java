package srok.test.programmers;

public class ExpressingNumbers {
	public static void main(String[] args) {
		System.out.println(solution(15));		//4
		System.out.println(solution(1500));
	}

	public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        for(int idx = 1; idx <= n; idx++) {
        	sum = 0;
        	for(int inner_idx = idx; inner_idx <= n && sum < n; inner_idx++) {
        		sum += inner_idx;
        		if(sum == n) {
//        			System.out.println("result : " + idx + "~" + inner_idx);
        			answer++;
        		}
        	}
        }
        return answer;
    }
}