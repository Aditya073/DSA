class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> map = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        int left = 0;
        int count = 0;
        int curr = 0;

        for (int right = 0; right < s.length(); right++) {

            if (map.contains(s.charAt(right))) {
                curr++;
            }

            while (right-left+1 > k) {
                if (map.contains(s.charAt(left))) {
                    curr--;
                }
                left++;
            }
            if (right-left+1 == k) {
                count = Math.max(count, curr);
            }

        }
        return count;
    }
}