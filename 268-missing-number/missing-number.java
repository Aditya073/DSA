class Solution {
    public int missingNumber(int[] nums) {
        // 0 ^ 1 ^ 2 ^ ... ^ n ^ nums[0] ^ nums[1] ^ nums[2]...
        int xor = nums.length;
        for(int i = 0; i < nums.length; i++){
            xor ^= i;
            xor ^= nums[i];
        }
        //so at the end the answer would be the missing num
        return xor;
    }
}