package srok.test.programmers;

public class ConvertWord {
	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
		System.out.println(solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log"}));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		answer = convertWord(begin,target,words,-1);
        return answer;
	}
	
	private static int convertWord(String currentWord, String targetWord, String[] words, int cnt) {
		int result = 99;
		cnt++;
		if(currentWord.equals(targetWord)){
			result = cnt;
		} else {
			for(int idx = 0; idx< words.length; idx++) {
				if(compareWords(currentWord,words[idx]) == 1) {
					String findWord = words[idx];
					words[idx] = "";
					int val = convertWord(findWord,targetWord,words, cnt);
					words[idx] = findWord;
					if(result > val ) {
						result = val;
					}
				}
			}
		}
		
		if(cnt == 0 && result == 99) {
			result = 0;
		}
		return result;
	}
	
	//문자열 비교
	private static int compareWords(String a, String b) {
		int result = 0;
		for(int idx = 0;!b.equals("") && idx< a.length(); idx++) {
			if(a.charAt(idx) != b.charAt(idx)) {
				result++;
			}
		}
		return result;
	}
}