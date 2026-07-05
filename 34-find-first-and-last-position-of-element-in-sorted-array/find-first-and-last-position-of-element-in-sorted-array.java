class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] no = {-1,-1};
        int start = 0;
        int end = nums.length-1; 

        if(nums.length == 0){
            return new int[]{-1, -1};        
        }

        if(nums.length == 1 && nums[0] == target) return new int[]{0, 0};
        
        while(start <= end){ 
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return targetSearch(nums, mid, target);
            }
            else if(nums[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
           
        }
        return no;
    }

    public int[] targetSearch(int[] nums, int mid, int target){

        int left = mid;
        int right = mid;

        while (left > 0 && nums[left - 1] == target) {
            left--;
        }

        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }

        return new int[]{left, right};
    }
}