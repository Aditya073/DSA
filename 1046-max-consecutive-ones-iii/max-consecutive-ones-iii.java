class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) { // use up all the 'k' to make a large window
                k--;
            }

            // If k becomes negative, you've used too many flips, so shrink until it's valid again.
            while (k < 0) {
                if (nums[left] == 0)
                    k++;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}