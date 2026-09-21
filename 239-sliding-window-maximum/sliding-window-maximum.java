class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(
                (a, b) -> nums[b] - nums[a]
            );
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            q.offer(i);
            pq.offer(i);
        }

        ans[0] = nums[pq.peek()];

        for (int i = k; i < nums.length; i++) {
            q.offer(i);
            pq.offer(i);

            if (q.size() > k) {
                q.poll();
            }

            // Remove indices outside current window
            while (!pq.isEmpty() && pq.peek() <= i - k) {
                pq.poll();
            }

            ans[i - k + 1] = nums[pq.peek()];
        }

        return ans;
    }
}