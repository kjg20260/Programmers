import java.util.HashMap;

class Solution {
    private String leftHandLoc;
    private String rightHandLoc;
    private HashMap<String,int[]> map;

	public Solution() {
		this.leftHandLoc = "*";
		this.rightHandLoc = "#";
		this.map = new HashMap<String, int[]>();
		
		for(int i = 1; i<10; i++) {
        	map.put(String.valueOf(i), new int[]{(i-1)/3,(i-1)%3});
        }
        map.put("*", new int[]{3,0});
        map.put("0", new int[]{3,1});
        map.put("#", new int[]{3,2});
	}
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String targetPad = "";
        int leftDistance = 0;
        int rightDistance = 0;
        
        for(int i = 0; i<numbers.length; i++) {
        	targetPad = String.valueOf(numbers[i]);
        	
        	if(Integer.parseInt(targetPad) % 3 == 2 || targetPad.equals("0")) {
            	leftDistance = getDistance(leftHandLoc,targetPad);
            	rightDistance = getDistance(rightHandLoc,targetPad);
            	
            	if(leftDistance > rightDistance || (leftDistance == rightDistance && hand.equals("right")) ) {
            		rightHandLoc = targetPad;
            		answer += "R";
            	}else if(leftDistance < rightDistance || (leftDistance == rightDistance && hand.equals("left"))) {
            		leftHandLoc = targetPad;
            		answer += "L";
            	}
        	}else if(Integer.parseInt(targetPad) % 3 == 1) {
        		leftHandLoc = targetPad;
        		answer += "L";
        	}else if(Integer.parseInt(targetPad) % 3 == 0) {
        		rightHandLoc = targetPad;
        		answer += "R";
        	}
        }
        return answer;
    }
    
    private int getDistance(String x, String y) {
		return Math.abs(map.get(x)[0] - map.get(y)[0]) + Math.abs(map.get(x)[1] - map.get(y)[1]);
	}
}