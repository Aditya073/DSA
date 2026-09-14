class Pair {
    int freq;
    String word;

    Pair(int f, String w) {
        this.freq = f;
        this.word = w;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();

        // iterate through the Str array and make a pair which should be stored in the hashMap
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // create a MaxHeap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return a.freq - b.freq;
            }
            return b.word.compareTo(a.word);
        });

        // then iterate through the HashMap and make a pair
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Pair currPair = new Pair(entry.getValue(), entry.getKey());

            // check the heap and add the elements to the heap
            if (pq.size() < k) {
                pq.offer(currPair);
            } else {
                Pair top = pq.peek();

                if (currPair.freq > top.freq ||
                        (currPair.freq == top.freq &&
                                currPair.word.compareTo(top.word) < 0)) {

                    pq.poll();
                    pq.offer(currPair);
                }
            }
        }

        // for the higest Kth elements make the arrayList and add the word
        while (!pq.isEmpty()) {
            Pair top = pq.peek();
            ans.add(0, top.word); //we always insert at index 0
            pq.poll();
        }
        return ans;
    }
}
