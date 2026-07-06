class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // edge case
        if(k == nums.length) return nums;

        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // add the number and its freq in the HashMap
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> map.get(a)-map.get(b)
        );

        for(int n:map.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        // add heap elements to the ans array
        for(int j = 0; j < k; j++){
            ans[j] = heap.poll();
        }
        return ans;
    }
}