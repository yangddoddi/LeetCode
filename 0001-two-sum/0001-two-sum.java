class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        
        for (int i=0; i<nums.length; i++) {
            list.add(new int[]{nums[i], i});
        }
        
        Collections.sort(list, (e1, e2) -> e1[0] - e2[0]);
        
        int l = 0;
        int r = list.size()-1;
        for (;;) {
            int temp = list.get(l)[0] + list.get(r)[0];

            if (temp > target) {
                r--;
            }
            
            if (temp < target) {
                l++;
            }
            
            if (temp == target) {
                int[] n1 = list.get(l);
                int[] n2 = list.get(r);
                
                int[] answer = new int[]{n1[1], n2[1]};
                return answer;
            }
        }
    }
}