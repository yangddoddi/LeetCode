class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("시작 = " + c);
            
            if (map.containsKey(c)) {
                while (map.containsKey(c)) {
                    char ch = queue.poll();
                    map.remove(ch);
                }
            }
            
            map.put(c, 1);
            queue.add(c);
                
            answer = Math.max(answer, map.size());
            }
        
        return answer;
        }
    }