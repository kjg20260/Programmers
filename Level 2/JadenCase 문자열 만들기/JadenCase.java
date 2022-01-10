package srok.test.programmers;

public class JadenCase {
	public static void main(String[] args) {
		System.out.println(solution("3people unFollowed me"));	//3people Unfollowed Me
		System.out.println(solution("for the last week"));		//For The Last Week
		System.out.println(solution("will show everything without a  label #.3 "));		//For The Last Week
	}

	public static String solution(String s) {
		s = s.toLowerCase();
        String[] strArray = s.split(" ");
        for(int idx = 0; idx < strArray.length; idx++) {
        	if(strArray[idx].length() <= 1) {
        		strArray[idx] = strArray[idx].toUpperCase();
        	} else {
        		strArray[idx] = strArray[idx].substring(0,1).toUpperCase()+strArray[idx].substring(1);
        	}
        }
        String temp = String.join(" ", strArray);
        return s.replace(s.substring(0, temp.length()), temp);
    }
}