class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            // we are shrinking the window as many times as needed until the window becomes valid
            while (set.contains(s.charAt(right))) {
                // while any new element is same as the prevously added element then decrease the size of the sliding window
                set.remove(s.charAt(left));
                left++;
            }
            // now there are no duplicates
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }
}