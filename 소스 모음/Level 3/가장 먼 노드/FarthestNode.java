package srok.test.programmers;

import java.util.Arrays;

public class FarthestNode {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 }  }));
	}

	public static int solution(int n, int[][] edge) {
		int answer = 0;
		int[] arr = new int[n];		//queue 대신 사용할 size가 n인 배열
		int currentIdx = 0;			//배열의 현재 index --- queue에서 pop 을 currentIdx+1 로 대체
		int currentDepthIdx = 0;	//현재 depth의 마지막 index
		int cnt = 0;				//현재 depth의 카운트
		
		String[] list = new String[n];	//인접 리스트 만들기 
		boolean[] visited = new boolean[n];	//방문한 정점 체크용 배열 
		Arrays.fill(list, "");	//초기화
		for(int idx=0;idx < edge.length; idx++) {	//인접 리스트 값 입력
			list[edge[idx][0]-1] += (list[edge[idx][0]-1].equals("") ? "" : "/") + String.format("%x", edge[idx][1]);
			list[edge[idx][1]-1] += (list[edge[idx][1]-1].equals("") ? "" : "/") + String.format("%x", edge[idx][0]);
		}
		
		//풀이 BFS ---- queue 대신 array 사용
		visited[0] = true;
		while(currentIdx < n) {
			String[] temp = list[arr[currentIdx]].split("/");
			
			for(int index = 0; index < temp.length; index++) {
				int nextNode = Integer.parseInt(temp[index],16)-1;
				if(!visited[nextNode]) {//방문하지 않은 정점이 있으면 추가 
					visited[nextNode] = true;
					arr[currentDepthIdx+cnt+1] = nextNode;
					cnt++;
					answer++;
				}
			}
			
			if(currentIdx == currentDepthIdx) {	//현재 idx가 현재 depth의 마지막 Idx와 동일할 경우 --- 다음 뎁스의 마지막 idx 갱신 및 cnt 초기화 
				currentDepthIdx += cnt;
				cnt = 0;
				if(currentDepthIdx+1 != n) {//마지막 초기화 X
					answer = 0;
				}
			}
			currentIdx++;
		}
		
		return answer;
	}
}