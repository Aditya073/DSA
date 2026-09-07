class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // 1. create the ans of size k and a heap of same size
        int[][] ans = new int[k][2];

        // Max heap based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0]));
        // 2. for every point cal the distance of the 2 points and add them
        for (int i = 0; i < points.length; i++) {

            int x = points[i][0];
            int y = points[i][1];

            int distance = x * x + y * y;

            // Store {distance, index}
            int[] current = { distance, i };

            if (maxHeap.size() < k) {
                maxHeap.offer(current);
            } else if (maxHeap.peek()[0] > distance) {
                maxHeap.poll();
                maxHeap.offer(current);
            }
        }

        // Get the k points from heap
        for (int i = 0; i < k; i++) {
            int index = maxHeap.poll()[1];
            ans[i] = points[index];
        }

        return ans;
    }
}