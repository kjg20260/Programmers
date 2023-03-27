import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
		HashMap<String, Integer> idMap = new HashMap<String, Integer>();
		for (int idx = 0; idx < id_list.length; idx++) {
			idMap.put(id_list[idx], idx);
		}
        //배열의 스트림을 이용해서 간단하게 풀어봤습니다
		Arrays.stream(report).distinct()
				.collect(Collectors.groupingBy(x -> x.toString().split(" ")[1],
						Collectors.mapping(y -> y.toString().split(" ")[0], Collectors.toList())))
				.forEach((key, list) -> {
					if (list.size() >= k) {
						for (String str : list) {
							answer[idMap.get(str)] += 1;
						}
					}
				});
		return answer;
    }
}