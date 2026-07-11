class Solution {
    public int countSubstrings(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += palindromeCheck(s, i, i);
            sum += palindromeCheck(s, i, i + 1);
        }
        return sum;

    }

    public int palindromeCheck(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}