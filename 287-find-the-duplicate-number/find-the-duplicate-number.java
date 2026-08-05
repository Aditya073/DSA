class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        // find the intersection point 
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // find the enterence to the cycle
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}