class Solution {
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // "ans.length() > 0" ---> null cleck
            /* ASCII value 
            A = 65 , a = 97 
            B = 66 , b = 98
            sooo if the difference is 32 that means we found the " two adjacent characters s[i] and s[i + 1]" 
            */
            if(ans.length() > 0 && Math.abs(ans.charAt(ans.length()-1) - s.charAt(i)) == 32){
                ans.deleteCharAt(ans.length()-1);
                continue;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();

    }
}