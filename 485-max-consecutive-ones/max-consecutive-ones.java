class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int iterator = 0; iterator < nums.length; iterator++) {
            if (nums[iterator] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
                continue;
            }
        }

        return maxCount;
    }
}

/*   Slidding window approach]

int max = 0;
int curr = 0;
int left = 0;

for (int right = 0; right < nums.length; right++) {
    if (nums[right] == 1) {
        curr++;
        max = Math.max(curr, max);
    }
    if (nums[right] == 0) { // shrinking the window
        left = right;
        curr = 0;
    }
}
return max;
*/