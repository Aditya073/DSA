class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int count = 0;

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre = pre + nums[i];

            if(map.containsKey(pre - k)){
                count += map.get(pre - k);

            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;

    }
}