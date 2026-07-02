class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefix = new int[nums.length]; //left to right
        int[] suffix = new int[nums.length]; //right to left

        for (int i = 0, k = nums.length-1; i <= nums.length-1 && k >= 0; i++, k--) {
            if(i == 0 && k ==  nums.length-1){
                prefix[i] = 1;
                suffix[k] = 1;
            }
            else{
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[k] = suffix[k+1] * nums[k+1];
            }
        }
        int[] ans = new int[nums.length];
        for(int j = 0; j < nums.length; j++){
           ans[j] = prefix[j] * suffix[j];
        }
        return ans;
    }
}