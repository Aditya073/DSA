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
        // System.out.println(maxHeap.peek());
        // return 1;
        while(maxHeap.size() != 1){
            // Integer s1 = maxHeap.pop();
            // Integer s2 = maxHeap.pop();
            Integer diff = Math.abs(maxHeap.poll() - maxHeap.poll());
            maxHeap.offer(diff);
        }
        return maxHeap.poll();

    }
}