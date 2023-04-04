class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[] road = new int[n * m];
        road[0] = 1; //시작점
        
        for(int[] puddle:puddles) {//웅덩이 만들기
        	road[(puddle[1]-1) * m + (puddle[0]-1)] = -1;
        }
        
        for(int i=1; i<road.length; i++) {
        	if(road[i] != -1) {
        		if(i % m != 0 && road[i-1] != -1) {
        			road[i] += road[i-1] % 1000000007;
        		}
        		
        		if(i >= m && road[i-m] != -1) {
        			road[i] += road[i-m] % 1000000007;
        		}
        	}
        }
        
        answer = road[road.length-1];
        return answer % 1000000007;
    }
}