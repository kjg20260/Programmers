package srok.test.programmers;

public class Square {
	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}

    public static long solution(int w, int h) {
        long answer = 1;
        long big = w >= h ? w : h;
        long small = w < h ? w : h; 
        long gcd = small;
        
        while(big % small != 0) {
        	gcd = big % small;;
        	big = small;
        	small = gcd;
        }
        answer = (long)w * (long)h - w - h + gcd;
        return answer;
    }	
}