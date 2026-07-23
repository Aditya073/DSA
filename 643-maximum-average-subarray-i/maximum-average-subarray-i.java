class Solution {
    public double findMaxAverage(int[] nums, int k) {
       
        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;

        // Slide the window
        for (int right = k; right < nums.length; right++) {

            sum += nums[right]; // Add new element
            sum -= nums[right - k]; // Remove old element

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}