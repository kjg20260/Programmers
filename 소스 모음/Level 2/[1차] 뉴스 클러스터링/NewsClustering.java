package srok.test.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class NewsClustering {
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}

	public static int solution(String str1, String str2) {
		int answer = 0;
		long intersection = 0;
		long union = 0;
		int sixteen = 65536;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String temp = "";
		str1 = str1.toLowerCase().replaceAll("[^a-z]", " ");
		str2 = str2.toLowerCase().replaceAll("[^a-z]", " ");
		
		for(int idx1 = 1; idx1<str1.length(); idx1++) {
			temp = str1.substring(idx1-1, idx1+1);
			if(temp.trim() == temp) {
				union += 1;
				map.put(temp, map.get(temp)==null?1:map.get(temp)+1);
			}
		}
	
		for(int idx2 = 1; idx2<str2.length(); idx2++) {
			temp = str2.substring(idx2-1, idx2+1);
			if(temp.trim() == temp) {
				if(map.get(temp) != null && map.get(temp) > 0) {
					map.put(temp, map.get(temp) - 1);
					intersection += 1;
				} else {
					union += 1;
				}
			}
		}
		answer = (int) (intersection == 0 && union == 0 ? sixteen : Math.floorDiv(intersection * sixteen, union));
		return answer;
	}
}
