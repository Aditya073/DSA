import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> hashSet = new HashSet<>(k);

        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) return true;
            hashSet.add(nums[i]);

            // to maintain the window of size k
            if(hashSet.size() > k){
                //this removes the first element from the hashSet
                hashSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}