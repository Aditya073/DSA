import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i+1; j < nums.length && count < k; j++){
                count++;
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;

        // if (duplicate == null) return false;
        // System.out.println(duplicate);
        // // now we have the duplicate

        // // get the index of the duplicate elements
        // int count = 0;
        // int[] list_of_duplicate_index = new int[nums.length];

        // for (int j = 0; j < nums.length; j++) {
        //     if (nums[j] == duplicate) {
        //         list_of_duplicate_index[count] = j;
        //         count++;
        //     }
        // }

        // // check for the condition given in the question
        // for (int z = 0; z < count - 1; z++) {
        //     if ((list_of_duplicate_index[z + 1] - list_of_duplicate_index[z]) <= k)
        //         return true;
        // }

        // return false;
    }
}