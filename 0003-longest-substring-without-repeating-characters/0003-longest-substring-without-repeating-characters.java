class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        
        int answer = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (map.containsKey(c)) {
                while (true) {
                    char c2 = s.charAt(left);
                    
                    if (c2 == c) {
                        left++;
                        map.remove(c2);
                        break;
                    }
                    
                    left++;
                    map.remove(c2);
                }
            }
            
            map.put(c, 1);
            right++;
            answer = Math.max(answer, map.size());
        }
        
        return answer;
    }
}