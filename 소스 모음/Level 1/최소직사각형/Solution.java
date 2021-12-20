package srok.test.programmers;

public class MinimumRectangle {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
		System.out.println(solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
		System.out.println(solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
	}

	public static int solution(int[][] sizes) {
        int big_max = 0; //가로 세로 중 큰 값의 MAX
        int small_max = 0; //가로 세로 중 작은 값의 MAX
        
        for(int[] size : sizes) {
        	if(size[0] > size[1]) {
        		if(big_max < size[0]) {
        			big_max = size[0];
        		}
        		
        		if(small_max < size[1]) {
        			small_max = size[1];
        		}
        	}else {
        		if(big_max < size[1]) {
        			big_max = size[1];
        		}
        		
        		if(small_max < size[0]) {
        			small_max = size[0];
        		}
        	}
        }
        return big_max * small_max;
    }
}