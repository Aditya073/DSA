public class Solution {

    // converts digits to letters based on array indexing
    public String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        // edge case
        if (digits == null || digits.length() == 0) return ans;

        backTraking(ans, digits, "", 0);
        return ans;
    }

    public void backTraking(List<String> ans, String digits, String currentChar, int index) {
        if (index == digits.length()) { // base case
            ans.add(currentChar);
            return;
        }

        String letters = arr[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {
            backTraking(ans, digits, currentChar + letter, index + 1);
        }
    }

}
