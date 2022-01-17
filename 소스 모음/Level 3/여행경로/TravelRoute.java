package srok.test.programmers;

import java.util.Arrays;

public class TravelRoute {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } })));
//				["ICN", "JFK", "HND", "IAD"]
		System.out.println(Arrays.toString(solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" },{ "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } })));
//				["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
	}

	public static String[] solution(String[][] tickets) {
		String[] answer = traceRoute(tickets, "","").split(",");
		return answer;
	}

	private static String traceRoute(String[][] tickets, String route, String airport) {
		String result = null;
		for (int idx = 0; idx < tickets.length; idx++) {
			if(tickets[idx] == null ||(route == "" && !tickets[idx][0].equals("ICN"))) {	//불필요한 작업 스킵
				continue;
			}
			
			String currentRoute = route;
			String currentAirport = airport;

			if(currentRoute.equals("")) {
				currentRoute = tickets[idx][0];
				currentAirport = currentRoute;
			}
			
			if (currentAirport.equals(tickets[idx][0])) {
				currentRoute += ","+tickets[idx][1];
				if (currentRoute.split(",").length == tickets.length+1) {
					return currentRoute;
				} else {
					String [][] unusedTickets = Arrays.copyOf(tickets, tickets.length);
					unusedTickets[idx] = null;		//사용한 티켓 제거
					String temp = traceRoute(unusedTickets, currentRoute, tickets[idx][1]);
					if (temp != null && (result == null ||result.compareTo(temp) > 0)) {
						result = temp;
					}
					unusedTickets[idx] = tickets[idx];
				}
			}
		}
		return result;
	}
}
//	public static String[] solution(String[][] tickets) {
//		String resultStr = "";
//		for(int index=0; index<tickets.length; index++) {
//			if(tickets[index][0].equals("ICN")) {	//ICN에서만 시작
//				String tempStr = traceRoute(tickets, "ICN","ICN");
//				if (tempStr != null && (resultStr.equals("") ||resultStr.compareTo(tempStr) > 0)) {
//					resultStr = tempStr;
//				}
//			}
//		}
//		String[] answer = resultStr.split(",");
//		return answer;
//	}
//
//	private static String traceRoute(String[][] tickets, String route, String airport) {
//		String result = null;
//		for (int idx = 0; idx < tickets.length; idx++) {
//			if(tickets[idx] == null) {	//불필요한 작업 스킵
//				continue;
//			}
//			
//			String currentRoute = route;
//			String currentAirport = airport;
//
//			if (currentAirport.equals(tickets[idx][0])) {
//				currentRoute += ","+tickets[idx][1];
//				if (currentRoute.split(",").length == tickets.length+1) {
//					return currentRoute;
//				} else {
//					String [][] unusedTickets = Arrays.copyOf(tickets, tickets.length);
//					unusedTickets[idx] = null;		//사용한 티켓 제거
//					String temp = traceRoute(unusedTickets, currentRoute, tickets[idx][1]);
//					if (temp != null && (result == null ||result.compareTo(temp) > 0)) {
//						result = temp;
//					}
//					unusedTickets[idx] = tickets[idx];
//				}
//			}
//		}
//		return result;
//	}
//}