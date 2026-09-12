class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target) return 0;

        int firstIndex = 0;
        int lastIndex = nums.length - 1;
        int mid = 0;

        while (firstIndex <= lastIndex) {
            mid = firstIndex + (lastIndex - firstIndex) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[firstIndex] <= nums[mid]) {
                // left half is sorted

               if (nums[firstIndex] <= target && nums[mid] > target) {
                
                lastIndex = mid-1;
                }
                else{
                    firstIndex = mid + 1;
                }
            }
            else { // right half is sorted
                if (nums[mid] < target && target <= nums[lastIndex]) {
                
                firstIndex = mid + 1;
                }
                else{
                    lastIndex = mid - 1;
                }
            }

        }
       
     return -1;
    }
}
