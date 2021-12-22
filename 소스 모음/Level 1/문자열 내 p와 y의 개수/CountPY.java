package srok.test.programmers;


public class CountPY {
	public static void main(String[] args) {
		System.out.println(solution("pPoooyY"));
		System.out.println(solution("Pyy"));
	}

	public static boolean solution(String s) {
        boolean answer = true;
        String[] split = s.toLowerCase().split("");
        int num = 0;
        
        for(String str : split) {
        	if(str.equals("p")) {
        		num++;
        	}else if(str.equals("y")) {
        		num--;
        	}
        }
        
        if(num != 0) {
        	answer = false;
        }
        
        return answer;
    }
}