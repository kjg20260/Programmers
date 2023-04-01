import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
		int start = 0;
		int end = people.length - 1;
		Arrays.sort(people);

		for (int i = end; i >= start && people[i] >= limit / 2; i--) {
			for (int j = start; j <= end && people[j] <= limit / 2; j++) {
				if (people[i] + people[j] <= limit) {
					start++;
					break;
				}else {
					break;
				}
			}
			end--;
			answer++;
		}
		if(end > start) {
			answer+= (end-start)/2+1;			
		}
		return answer;
    }
}