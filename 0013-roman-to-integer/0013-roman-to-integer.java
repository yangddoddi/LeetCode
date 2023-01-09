class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int answer = 0;
        char prev = s.charAt(0);
        answer += map.get(prev);
        
        for (int i=1; i<s.length(); i++) {
            char curr = s.charAt(i);
            
            int prevValue = map.get(prev);
            int currValue = map.get(curr);
            
            if (prevValue < currValue) {
                answer -= map.get(prev) * 2;
            }
            
            answer += map.get(curr);
            prev = curr;
        }
        
        return answer;
    }
}