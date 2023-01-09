class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        List<String> list = Arrays.stream(s.split("")).map(e -> e).collect(Collectors.toList());
        
        int answer = 0;
        for (int i=0; i<list.size()-1; i++) {
            String temp = list.get(i) + list.get(i+1);
            
            if (map.containsKey(temp)) {
                answer += map.get(temp);
                list.remove(i);
                list.remove(i);
                
                i -= 1;
            }
        }
        
        for (String str : list) {
            answer += map.get(str);
        }
        
        return answer;
    }
}