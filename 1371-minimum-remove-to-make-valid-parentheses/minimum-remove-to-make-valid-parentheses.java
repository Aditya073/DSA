class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder(s);

        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '(') {
                stack.push(i);
            } else if (ans.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    ans.deleteCharAt(i);
                    i--;
                }
            }
        }

        while (!stack.isEmpty()) {
            ans.deleteCharAt(stack.pop());
        }

        return ans.toString();
    }
}
// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         Deque<Integer> stack = new ArrayDeque<>();
//         StringBuilder ans = new StringBuilder();
//         Set<Integer> removeIndex = new HashSet<>();

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (c == '(') {
//                 stack.push(i);
//             } else if (c == ')') {
//                 if (!stack.isEmpty()) {
//                     stack.pop();
//                 } else {
//                     removeIndex.add(i);
//                 }
//             }
//         }

//         // add the remaining '(' ')' elements that were not closed 
//         while (!stack.isEmpty()) {
//             removeIndex.add(stack.pop());
//         }

//         for (int i = 0; i < s.length(); i++) {
//             if (!removeIndex.contains(i)) {
//                 char c = s.charAt(i);
//                 ans.append(c);
//             }
//         }

//         return ans.toString();
//     }
// }