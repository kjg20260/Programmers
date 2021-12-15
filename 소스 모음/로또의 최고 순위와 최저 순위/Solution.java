import java.util.Arrays;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
		int hide = 0;
		int win = 0;
		for (int lotto : lottos) {
			if (lotto != 0) {
				for (int i = 0; i < win_nums.length; i++) {
					if (win_nums[i] == lotto) {
						win++;
					}
				}
			} else {
				hide++;
			}
		}
		answer[0] = 7 - win - hide > 5 ? 6 : 7 - win - hide;
		answer[1] = 7 - win > 5 ? 6 : 7 - win;
		return answer;
    }
}