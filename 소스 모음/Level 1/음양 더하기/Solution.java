class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int dir = 0;
        for(int i = 0; i < absolutes.length; i++){
            dir  = signs[i]? 1 : -1;
            answer += dir * absolutes[i];
        }
        return answer;
    }
}