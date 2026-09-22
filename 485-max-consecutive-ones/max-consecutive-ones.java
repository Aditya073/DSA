class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                curr++;
                max = Math.max(curr, max);
            }
            if (nums[right] == 0) { // shrinking the window
                left = right;
                curr = 0;
            }
        }
        return max;
    }
}