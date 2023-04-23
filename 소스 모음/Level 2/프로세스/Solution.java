class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int max = priorities.length;
        int cur = 0;
        for(int priority = 9; priority >= priorities[location]; priority--) {
        	cur = max;
        	for(int i = 0; i< priorities.length; i++) {
        		cur = (cur) % priorities.length;
        		if(priorities[cur] == priority) {
        			max = cur;
        			answer++;
        			if(cur == location) {
        				break;
        			}
        		}
        		cur++;
        	}
        }
        
        return answer;
    }
}