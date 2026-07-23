class Solution {
    public int findLHS(int[] nums) {
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // freq map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // iterate through the map 
        // and get the freq of nums[key] && nums[key + 1]   
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                count = Math.max(count,
                        map.get(key) + map.get(key + 1));
            }
        }
        return count;

    }
}