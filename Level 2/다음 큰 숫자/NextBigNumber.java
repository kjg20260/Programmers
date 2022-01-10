package srok.test.programmers;

public class NextBigNumber {
	public static void main(String[] args) {
		System.out.println(solution(78));	//83
		System.out.println(solution(15));	//23
		//78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

		//15(1111)의 다음 큰 숫자는 23(10111)입니다.
	}

	public static int solution(int n) {
        int answer = 0;
        int bitcount = Integer.bitCount(n);
        
        for(int i = 1; i < n; i++) {
        	if(Integer.bitCount(n+i) == bitcount){
        		answer = n+i;
        		break;
        	}
        }
        
        return answer;
    }
}