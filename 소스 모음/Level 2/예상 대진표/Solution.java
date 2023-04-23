class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = (int) (Math.log(n) / Math.log(2)) + 1;
		int big = a >= b ? a : b;
		int small = a < b ? a : b;
		int up = n;
		int down = 0;
		
		while (!(small <= n && n < big ) && n > 1) {
			n = Integer.rotateRight(up + down, 1);
			answer--;
			if(n >= big) {
				up = n;
			}else if(n <= small) {
				down = n;
			}
		}
        return answer;
    }
}