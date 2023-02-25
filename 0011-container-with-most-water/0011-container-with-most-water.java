class Solution {
    public int maxArea(int[] height) {
        int low=0;
        int high=height.length-1;
        int currSum=0;
        int maxSum=0;
        while(low<high)
        {
            currSum=(high-low)*Math.min(height[low],height[high]);
            maxSum=Math.max(currSum,maxSum);
            if(height[low]<height[high])
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        return maxSum;
    }
}