class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minCount = nums.length+1;
        int sum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            // keep updating
            while(sum >= target){
                minCount = Math.min(minCount, right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        // final check
        return minCount == nums.length+1 ? 0 : minCount;
    }
}