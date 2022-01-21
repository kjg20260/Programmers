package srok.test.programmers;

public class Triangle {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
		for(int i = 1; i<triangle.length; i++) {
			for(int j=0; j<triangle[i].length; j++) {
				if(j == 0) {
					triangle[i][j] += triangle[i-1][j]; 
				}else if(j == triangle[i].length - 1){
					triangle[i][j] += triangle[i-1][j-1];
				}else {
					triangle[i][j] += triangle[i-1][j] >= triangle[i-1][j-1]?triangle[i-1][j] : triangle[i-1][j-1];
					if(i== triangle.length-1 && answer < triangle[i][j]) {
						answer = triangle[i][j];
					}
				}
			}
		}
        return answer;
    }
}
