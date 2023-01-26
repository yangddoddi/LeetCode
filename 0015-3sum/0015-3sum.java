class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length-1; i++) {
            int j = i+1;
            int k = nums.length-1;
                
            while (j < k) {
                int n = nums[i] + nums[j] + nums[k];
                
                if (n > 0) {
                    k--;
                }
                
                if (n < 0) {
                    j++;
                }
                
                if (n == 0) {
                    List<Integer> list = List.of(nums[i], nums[j], nums[k]);
                    set.add(list);
                    j++;
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}