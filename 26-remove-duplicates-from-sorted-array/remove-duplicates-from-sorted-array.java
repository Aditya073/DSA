class Solution {
    public int removeDuplicates(int[] nums) {
        int first = 0;
        int second = 1;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[first] != nums[second]){
                nums[first + 1] = nums[second];
                first++;
            }
            second++;
        }
        return first+1;
    }
}