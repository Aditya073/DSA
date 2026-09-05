class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k); // ---> create a heap of size k

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // after receiving the new element check
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) { // val is greater than the kth element on the heap
            minHeap.poll(); // remove that element 
            minHeap.offer(val); // add the val

        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */