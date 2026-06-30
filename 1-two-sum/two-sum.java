class Solution {
    public int[] twoSum(int[] nums, int target) {

        //create a hashmap
        Map<Integer, Integer> hashMap = new HashMap<>();

        // itterate through the array
        for (int i = 0; i < nums.length; i++) {
           int difference =  target - nums[i]; //store the difference 
           // check if the deference is in the hashmap
           if (hashMap.containsKey(difference)){
               return new int[]{hashMap.get(difference), i};//return the index of the diff
               
           }
           //add the value ---> as key & index ---> as value in hashmap
            hashMap.put(nums[i], i);
        }

        return null; // to avoid error
    }
}