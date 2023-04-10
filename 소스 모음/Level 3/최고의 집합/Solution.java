class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int div = Math.floorDiv(s , n);
        int rem = s % n;
        if(div==0) {	//s가 n보다 작을 때
        	return new int[] {-1};
        }
        
        /*s를 n으로 나눈 몫(div)으로 배열을 이루어져있으면 곱했을 때 제일 값이 큼 
         * 자연수 중 하나가 커지면 다른 자연수가 그만큼 작아져야함 
         * 예를 들면 div+1이면 다른 자연수중 하나는 div에서 -1 즉 div-1이 됨
         * (div+1) * (div-1) = div제곱 - 1 
         * 즉 div 2개를 넣으면 div제곱이므로 div 2개가 제일 큼
         * 
         * 비슷한 방법으로 n이 홀수개 일 때도 div로 채우는 게 제일 크다는 것을 알 수 있다
         * */
        for(int idx = 0; idx < answer.length; idx++) {
        	if(idx >= n-rem) {
            	answer[idx] = div + 1;
        	} else {
        		answer[idx] = div;
        	}
        }
        return answer;
    }
}