class Solution {
    public int[] shuffle(int[] nums, int n) {
        int pointer = n;
        int j = 0;
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0){
                ans[i] = nums[j];
                j++;
            }
            else{
                ans[i] = nums[pointer];
                pointer++;
            }
        }
        return ans;
    }
}