package srok.test.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQ {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"I 16","D 1"})));					//[0,0]
		System.out.println(Arrays.toString(solution(new String[] {"I 7","I 5","I -5","D -1"})));	//[7,5]
	}

	public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s: operations) {
        	String command = s.split(" ")[0];
        	int num = Integer.parseInt(s.split(" ")[1]);
        	if(command.equals("I")) {
        		pq.add(num);
        		reversePq.add(num);
        	}else if(command.equals("D") && num == 1) {
        		pq.remove(reversePq.poll());
        	}else if(command.equals("D") && num == -1) {
        		reversePq.remove(pq.poll());
        	}
        }
        
        answer[0] = reversePq.peek() != null? reversePq.poll() : 0;
        answer[1] = pq.peek() != null? pq.poll():0;
        return answer;
    }
}