import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>(); 
        Map<String, Integer> totalTimeMap = new HashMap<>(); 
        
        for (String record : records) {
            String[] parts = record.split(" ");
            int time = convertToMinutes(parts[0]);
            String carNumber = parts[1];
            String action = parts[2];
            
            if (action.equals("IN")) {
                inTimeMap.put(carNumber, time);
            } else {
                int inTime = inTimeMap.remove(carNumber);
                int parkedTime = time - inTime;
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
            }
        }
        
        int endTime = convertToMinutes("23:59");
        for (String carNumber : inTimeMap.keySet()) {
            int parkedTime = endTime - inTimeMap.get(carNumber);
            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
        }
        
        List<String> sortedCars = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(sortedCars);
        
        int[] answer = new int[sortedCars.size()];
        int index = 0;
        for (String carNumber : sortedCars) {
            answer[index++] = calculateFee(totalTimeMap.get(carNumber), fees);
        }
        
        return answer;
    }
    
    private int convertToMinutes(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
    
    private int calculateFee(int totalMinutes, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (totalMinutes <= baseTime) {
            return baseFee;
        }
        
        int extraTime = totalMinutes - baseTime;
        int extraUnits = (extraTime + unitTime - 1) / unitTime;
        return baseFee + extraUnits * unitFee;
    }
}
