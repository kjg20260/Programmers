package srok.test.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Tuple {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
		System.out.println(Arrays.toString(solution("{{123}}")));
		System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}

	/*
		 기본 원리 : 
		 	{a} 원소 한 개 짜리 의 값이 배열 첫번째 [a]
		 	{a, b} 원소 한 개 짜리에서 추가 된 값이 배열의 2번째 [a,b]
		 	... 반복
		 	{a,b,d,c,e} => [a,b,d,c,e]
		 	원소의 순서가 정렬이 안되어있어서 복잡해 보이지만 단순합니다.
		 	주어진 문자열에서 제일 많이 나온 숫자가 배열의 첫 번째가 될 것이고 그 다음이 두번째... 반복
		 	
	 	풀이 순서: 
		 	괄호 삭제 후 -> ',' 쉼표로 split하여 각 숫자들의 개수를 구하면 끝
		 	
		 	
		 	맵으로 카운트하는 방식 사용
		 	map.put(숫자,개수);
		 	
		 	이 맵을 통해 answer에 넣어서 반환하면 된다.
		 	answer[숫자의 총 개수 - 개수] = 숫자;
		 	※배열의 인덱스 값을 (숫자의 총 개수 - 개수)로 한 이유 :인덱스 값을 제일 개수가 많은 것부터 역순으로 넣기 위해서
	 */
	public static int[] solution(String s) {
		int[] answer = {};
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		String[] strArray = s.replaceAll("\\{|\\}","").split(",");
		
		for(String str : strArray) {
			int key = Integer.parseInt(str);
			int cnt = map.get(key) != null ? map.get(key) + 1 : 1;
			map.put(key,cnt);
		}
		
		answer = new int[map.size()];
		for(Entry<Integer, Integer> set : map.entrySet()) {
			answer[map.size() - set.getValue()] = set.getKey();
		}
		
        return answer;
	}
}