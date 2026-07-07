class Solution {
    public void moveZeroes(int[] nums) {
        
        int first = 0;
        int second = first+1;

        while(second != nums.length){
            if(nums.length == 1) { // edge case
                break;
            }
            if(nums[first] == 0 && nums[second] != 0){
                // swap
                int temp = nums[first];
                nums[first] = nums[second];
                nums[second] = temp;
                first++;
            }
            if((nums[first] != 0 && nums[second] != 0) || 
            (nums[first] != 0 && nums[second] == 0)){
                first++;
            }
            second++;
        }
    }
}