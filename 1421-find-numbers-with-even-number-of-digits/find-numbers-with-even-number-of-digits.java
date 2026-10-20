class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int prt = nums[i];
            int check = 0;

            while(prt > 0){
                prt = prt / 10;
                check += 1;
            }
            if(check % 2 == 0){
                count++;
            }
        }
        return count;
    }
}