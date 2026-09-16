class Pair { // make a pair class
    int freq;
    Character s;

    Pair(int freq, Character s) {
        this.freq = freq;
        this.s = s;
    }
}

class Solution {
    public String reorganizeString(String s) {
        // count the freq of each chara in the "s" string using hashmap
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq) {
                        return b.freq - a.freq;
                    }
                    return a.s.compareTo(b.s);
                });

        // make the hashmap into pair
        // max heap of pair
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getValue(), entry.getKey());
            pq.offer(pair);
        }

        // put the string using the max freq first

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair topPair = pq.poll(); // remove the top heap element

            if (res.length() == 0 || topPair.s != res.charAt(res.length() - 1)) {
                res.append(topPair.s);
                topPair.freq--;
                if (topPair.freq > 0)
                    pq.offer(topPair);
            } else {
                if (!pq.isEmpty()) {
                    Pair secTopPair = pq.poll();
                    res.append(secTopPair.s);
                    secTopPair.freq--;
                    if (secTopPair.freq > 0)
                        pq.offer(secTopPair);
                    pq.offer(topPair);
                } else
                    return "";

            }
        }

        return res.toString();
    }
}