class Solution {
    public int countGoodSubstrings(String s) {
        int maxGoodSubstring = 0;
        int left = 0;
        if (s.length() < 3)
            return maxGoodSubstring;

        int[] freq = new int[26];

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            if ((right - left + 1) > 3) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            if ((right - left + 1) == 3) {
                if (freq[s.charAt(left) - 'a'] == 1
                        && freq[s.charAt(left + 1) - 'a'] == 1
                        && freq[s.charAt(right) - 'a'] == 1) {
                    maxGoodSubstring++;
                }
            }

        }
        return maxGoodSubstring;
    }
}