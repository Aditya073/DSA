class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ptr = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);

            while (!stack.isEmpty() && ptr < pushed.length && stack.peek() == popped[ptr]) {
                stack.pop();
                ptr++;
            }
        }
        return stack.isEmpty();
    }
}