class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left)+1];
		int row = (int) (left/n);
		int col = (int) (left%n);

		for(int a = 0; a<answer.length; a++) {
			answer[a] = col > row? col+1 : row+1;
			if(col == n-1) {
				row++;
				col = 0;
			} else {
				col++;
			}
		}
		
        return answer;
    }
}