import java.util.HashMap;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(String str : participant) {
        	int num = map.get(str) != null ? map.get(str) + 1 : 1;
        	map.put(str,num);
        }
        
        for(String str2 : completion) {
        	if(map.get(str2) == 1) {
        		map.remove(str2);
        	}else {
        		map.put(str2, map.get(str2)-1);
        	}
        }
        
        for(String setStr : map.keySet()) {
        	answer = setStr;
        }
        return answer;
    }
}