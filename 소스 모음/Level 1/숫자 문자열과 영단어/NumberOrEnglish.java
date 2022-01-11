package srok.test.programmers;

public class NumberOrEnglish {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));		//1478
		System.out.println(solution("23four5six7"));		//234567
		System.out.println(solution("2three45sixseven"));	//234567
		System.out.println(solution("123"));				//123
	}

	/*
	 * 
		숫자	영단어
		0	zero
		1	one
		2	two
		3	three
		4	four
		5	five
		6	six
		7	seven
		8	eight
		9	nine
	 * */
	
	public static int solution(String s) {
        int answer = 0;
        String[] words = new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int idx = 0; idx < words.length; idx++) {
        	s = s.replaceAll(words[idx], Integer.toString(idx));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}