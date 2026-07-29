class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
        
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                ans[index] = i - index;

            }
            stack.push(i);
        }

        return ans;
    }
}