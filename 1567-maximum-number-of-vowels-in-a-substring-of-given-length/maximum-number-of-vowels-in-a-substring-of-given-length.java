class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int curr = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            if (isVowel(s.charAt(right))) { // add the char to the window
                curr++; // if it is a vowel then increment the count
            }

            while (right - left + 1 > k) {
                if (isVowel(s.charAt(left))) { // if the char being removed is a vowel  
                    curr--; // then decrement the count
                }
                left++; // reduce the size of the window
            }

            if (right - left + 1 == k) { // update the max
                max = Math.max(max, curr); 
            }
        }

        return max;
    }

    private boolean isVowel(char c) { 
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}