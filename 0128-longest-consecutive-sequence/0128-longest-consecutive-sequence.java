class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        Set<Integer> set = new LinkedHashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int answer = 0;
        int cnt = 0;
        int temp = 0;
        for (Integer n : set) {
            if (cnt == 0 && temp == 0) {
                cnt ++;
                temp = n;
                continue;
            }

            if (n == temp+1) {
                cnt ++;
                temp = n;
                continue;
            }

            if (n != temp+1) {
                answer = Math.max(answer, cnt);
                cnt = 1;
                temp = n;
            }
        }

        return Math.max(answer, cnt);
    }
}