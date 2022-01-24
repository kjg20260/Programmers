package srok.test.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;


public class BestAlbum {
	public static void main(String[] args) {
		for(int s : solution(new String[] { "classic", "pop", "classic", "classic", "pop" , "classic", "pop" }, new int[] { 500, 600, 150, 800, 2500, 600, 150 })){
			System.out.println(s);
		};
	}

	public static int[] solution(String[] genres, int[] plays) {
		ArrayList<Integer> addList = new ArrayList<Integer>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0; i<genres.length; i++) {
			if(map.get(genres[i])!=null) {
				map.put(genres[i], map.get(genres[i]) + plays[i]);
				int id = i;
				int value = plays[i];
				
				if(value > map.get(genres[i]+"_1_val")) {
					id = map.get(genres[i]+"_1");
					value = map.get(genres[i]+"_1_val");
					map.put(genres[i]+"_1", i);
					map.put(genres[i]+"_1_val",plays[i]);
				}
				
				if (map.get(genres[i]+"_2_val") == null || map.get(genres[i]+"_2_val") != null && value > map.get(genres[i]+"_2_val")) {
					map.put(genres[i]+"_2", id);
					map.put(genres[i]+"_2_val",value);
				}
			}else {
				map.put(genres[i],plays[i]);
				map.put(genres[i]+"_1",i);
				map.put(genres[i]+"_1_val",plays[i]);
			}
		}
		
		map.keySet().stream().filter(x->!x.contains("_")).forEach(x->{
			addList.add(map.get(x+"_1"));
			if(map.get(x+"_2") != null) {
				addList.add(map.get(x+"_2"));	
			}
		});
		return addList.stream().mapToInt(i->i).toArray();
	}
	
	/* 방법 1 wtf
	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		ArrayList<Integer> addList = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<String, ArrayList<String>> valueMap = new HashMap<String, ArrayList<String>>();
		
		for(int i=0; i<genres.length; i++) {
			ArrayList<String> list = new ArrayList<String>();
			if(valueMap.get(genres[i]) != null) {
				list = valueMap.get(genres[i]);
				list.set(0, String.valueOf(Integer.parseInt(list.get(0)) + plays[i]));
			}else {
				list.add(String.valueOf(plays[i]));
			}
			int cIdx = list.size();
			list.add(plays[i] + "/" + i);
			
			while(cIdx != 1) {
				int pIdx = cIdx/2;
				int cValue = Integer.parseInt(list.get(cIdx).split("/")[0]);
				int pValue = Integer.parseInt(list.get(pIdx).split("/")[0]);
				
				if(cValue > pValue) {
					Collections.swap(list, cIdx, pIdx);
				}else {
					cIdx = 1;
				}
				cIdx = pIdx;
			}
			valueMap.put(genres[i], list);
		}
		
		valueMap.forEach((k,v)->{
			ArrayList<Integer> iList = new ArrayList<Integer>();
			iList.add(Integer.parseInt(v.get(1).split("/")[1]));
			if(v.size() > 2) {
				iList.add(Integer.parseInt(v.get(2).split("/")[1]));
			}
			if(v.size() > 3 && Integer.parseInt(v.get(3).split("/")[0]) > Integer.parseInt(v.get(2).split("/")[0])) {
				iList.set(1,Integer.parseInt(v.get(3).split("/")[1]));
			}
			map.put(Integer.parseInt(v.get(0)), iList);
			pq.add(Integer.parseInt(v.get(0)));
		});
		pq.forEach(x->{
			addList.addAll(map.get(x));
		});
		
		answer = addList.stream().mapToInt(i->i).toArray();
		return answer;
	}
	*/
	
}