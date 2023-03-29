class Solution {
    public int[] searchRange(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int start, end;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				int temp1 = mid;
				int temp2 = mid;
				while ((temp1 - 1) >= 0 && nums[temp1 - 1] == nums[mid]) {
					temp1--;
				}
				start = temp1;
				while ((temp2 + 1) <= nums.length - 1 && nums[temp2 + 1] == nums[mid]) {
					temp2++;
				}
				end = temp2;
				return new int[]{start, end};
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else low = mid + 1;
		}
		return new int[]{-1, -1};
    }
}