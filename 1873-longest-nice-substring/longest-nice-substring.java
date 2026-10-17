class Solution {
    public String longestNiceSubstring(String s) {
        /* 
        DEedrwWqQ  ---> DEed & wWqQ  ---> longestNiceSubstring = DEed
        
        Brute force
        1. generate all the possible Substring from the string "s" ---> nested loops---> O(n^2)
        2. Store them in a list
        3. maintain a variable "longestNiceSubstring"
        4. check from all the possible Substring if anyone is a "Nice Substring"
        5. if it is the largest so far update the "longestNiceSubstring" variable 
        6. return "longestNiceSubstring"
        */

        ArrayList<String> list = new ArrayList<>();
        String longestNiceSubstring = "";

        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                list.add(s.substring(i, j));
            }
        }

        // check
        for (String str : list) {
            if (isNice(str)) {
                // then check if it is the longest
                if (str.length() > longestNiceSubstring.length()) {
                    longestNiceSubstring = str;
                }
            }
        }
        return longestNiceSubstring;
    }

    // Checks whether a substring is nice
    private boolean isNice(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                if (!s.contains(
                        String.valueOf(Character.toUpperCase(ch)))) {
                    return false;
                }
            } else if (Character.isUpperCase(ch)) {
                /*
                Character.toUpperCase(ch) converts 'a' into 'A'.
                String.valueOf(...) converts the character 'A' into the string "A".
                s.contains("A") checks whether "A" exists in the original string.
                ! reverses the result. If "A" is missing, the condition becomes true.
                return false means the substring is not nice.
                */
                if (!s.contains(
                        String.valueOf(Character.toLowerCase(ch)))) {
                    return false;
                }
            }
        }

        return true;
    }
}