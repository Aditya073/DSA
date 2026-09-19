class Pair {
    int profit;
    int cap;

    Pair(int profit, int cap) {
        this.profit = profit;
        this.cap = cap;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        ArrayList<Pair> listOfPair = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            listOfPair.add(new Pair(profits[i], capital[i]));
        }

        // Sort by required capital
        listOfPair.sort((a, b) -> a.cap - b.cap);
        int idx = 0;

        while (k > 0) {

            // Add every project we can currently afford
            while (idx < listOfPair.size()
                    && listOfPair.get(idx).cap <= w) {

                maxHeap.offer(listOfPair.get(idx).profit);
                idx++;
            }

            // No available project
            if (maxHeap.isEmpty()) {
                break;
            }

            // Take the maximum profit
            int top = maxHeap.poll();

            w += top;
            k--;
        }

        return w;
    }
}