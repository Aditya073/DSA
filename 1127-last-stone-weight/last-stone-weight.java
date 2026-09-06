class Solution {
    public int lastStoneWeight(int[] stones) {
        // 1. if(array.size == 1) return array[0];
        // 2. we remove 2 highest stones from the array 
        // if(s1 == s2) continue;
        // if(s1 != s2){
        //  diff = s2 - s1;
        // array.add(diff);
        // continue;
        // }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int s1 = maxHeap.poll(); // largest
            int s2 = maxHeap.poll(); // second largest

            if (s1 != s2) {
                maxHeap.offer(s1 - s2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}