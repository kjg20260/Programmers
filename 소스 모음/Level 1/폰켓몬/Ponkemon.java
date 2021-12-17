package srok.test.programmers;

import java.util.HashSet;

public class Ponkemon {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,1,2,3}));
		System.out.println(solution(new int[] {3,3,3,2,2,4}));
		System.out.println(solution(new int[] {3,3,3,2,2,2}));
	}

	public static int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i:nums) {
        	set.add(i);
        }
        answer = set.size() > nums.length/2 ? nums.length/2 : set.size();
        return answer;
    }
}