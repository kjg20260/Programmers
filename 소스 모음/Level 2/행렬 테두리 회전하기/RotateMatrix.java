package srok.test.programmers;

import java.util.Arrays;

public class RotateMatrix {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 6, new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } })));
		
		System.out.println(Arrays.toString(solution(3, 3, new int[][] { { 1,1,2,2 }, { 1,2,2,3 }, { 2,1,3,2 }, {2,2,3,3} })));
		
		System.out.println(Arrays.toString(solution(100, 97, new int[][] { { 1,1,100,97 }})));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        
        //진행방향 설정 변수(시계 반대방향으로 돌면서 현재 위치에 시계방향상 이전 위치의 값을 넣어줌)
        int direction = 1;
        int changeCol = 0;
        int changeRow = 1;
        int temp = 0;
       
        for(int idx = 0; idx < queries.length; idx++) {
        	//높이, 너비, 둘레 길이
        	int height = queries[idx][2] - queries[idx][0];
        	int width = queries[idx][3] - queries[idx][1];
        	int round = 2 * (height + width);
        	
        	//현재 위치 및 이전 위치 초기값
        	int curRow = queries[idx][0]-1;
        	int curCol = queries[idx][1]-1;
        	int prevCol = 0;
        	int prevRow = 0;
        	
        	//시작점 value 보관 - 해당위치의 값이 0 일 경우  
        	temp = board[curRow][curCol] != 0 ? board[curRow][curCol] : (columns * curRow) + curCol +1;
        	for(int i = 0; i < round; i++) {
        		//이전 위치 x, y 구하기
        		prevCol = curCol + (changeCol * direction);
        		prevRow = curRow + (changeRow * direction);
        		
        		//현재 위치에 이전위치의 값 넣어주기
        		board[curRow][curCol] = board[prevRow][prevCol] != 0 ? board[prevRow][prevCol] : (columns * prevRow) + prevCol + 1;
        		if(i==round-1) {//마지막 위치에 시작점 value 입력
        			board[curRow][curCol] = temp;
        		}
        		
        		//다음에 진행될 방향 설정
        		if((i + width + 1) % (height + width) == 0) {//진행방향 가로로 변경
        			changeCol = 1;
        			changeRow = 0;
        		}else if((i +1) % (height + width) == 0) {//진행방향 세로로 변경
        			changeCol = 0;
        			changeRow = 1;
        			direction = -1 * direction;
        		}
        		
        		//해당 query에서 제일 작은 수 찾기
        		if(answer[idx] == 0 || answer[idx] > board[curRow][curCol]) {
        			answer[idx] = board[curRow][curCol];
        		}
        		
        		//이전 위치를 현재위치로 변경
        		curCol = prevCol;
        		curRow = prevRow;        		
        	}
//        	//출력 테스트 
//        	for (int a = 0; a < board.length; a++) {
//        		for (int b = 0; b < board[a].length; b++) {
//        			System.out.print(board[a][b] + "\t");
//        		}
//        		System.out.println();
//        	}
//        	System.out.println("-------------------------------------------------");
        }
        return answer;
    }
}