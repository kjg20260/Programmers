import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] height = new int[board.length];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < moves.length; i++) {
			int locX = moves[i]-1;
			int locY = height[locX];
			if(locY != board[locX].length) {
				int doll = board[locY][locX];
				if (doll > 0) {
					if (stack.size() > 0) {
						int top = stack.pop();
						if (top != doll) {
							stack.add(top);
							stack.add(doll);
						}else {
							answer += 2;
						}
					}else {
						stack.add(doll);
					}
				} else {
					i--;
				}
				height[locX] += 1;				
			}
		}
        return answer;
    }
}