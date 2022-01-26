package srok.test.programmers;

public class Network {
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));	//2
		System.out.println(solution(3, new int[][] {{1,1,0},{1,1,1},{0,1,1}}));	//1
		}

	public static int solution(int n, int[][] computers) {
        int answer = 0;
        //connect - 네트워크 연결된 컴퓨터들 체크
        int[] connect = new int[n];

        //단방향 연결 - 양방향으로 바꾸기 : 1-0은 연결(1)상태, 0-1은 연결X(0)라고 되어있는 경우가 있음
        for(int wtf=0; wtf<computers.length; wtf++) {
        	for(int wtf2 = wtf+1;wtf2<computers.length; wtf2++) {
        		if(computers[wtf][wtf2]==1 || computers[wtf2][wtf]==1) {
        			computers[wtf][wtf2] = 1;
        			computers[wtf2][wtf] = 1;
        		}
        	}
        }
        //connect 초기화
        for(int computer_idx = 0; computer_idx < computers.length; computer_idx++) {
        	if(connect[computer_idx] == 1) {				//이미 연결 된 컴퓨터
        		continue;
        	} else {
        		answer++; 									//네트워크 추가
        		trace(computer_idx,computers,connect);		//해당 네트워크에 포함되는 컴퓨터 추적
        	}
        }
        return answer;
    }
	
	private static void trace(int start, int[][] computers, int[] network) {
		network[start] = 1;
		for (int idx = 0; idx < computers.length; idx++) {
			if(idx == start || network[idx]==1) {
				continue;
			}
			if(computers[start][idx]==1) {
				network[idx] = 1;
				trace(idx,computers,network);
			}
		}
	}
}