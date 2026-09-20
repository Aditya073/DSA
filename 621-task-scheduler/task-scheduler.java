class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        // char & freq ----> pair
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max heap based on frequency
        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int minNumberOfInterval = 0;

        while (!heap.isEmpty()) {

            List<Pair> tempStorage = new ArrayList<>();
            int slots = n + 1;

            // Fill n + 1 positions
            while (slots > 0 && !heap.isEmpty()) {

                Pair current = heap.poll();
                minNumberOfInterval++;
                current.freq--;

                if (current.freq > 0) {
                    tempStorage.add(current);
                }
                slots--;
            }

            // Put temporarily removed characters back
            for (Pair pair : tempStorage) {
                heap.offer(pair);
            }

            // If tasks are still remaining, the unused slots are idle
            if (!heap.isEmpty()) {
                minNumberOfInterval += slots;
            }
        }

        return minNumberOfInterval;
    }
}