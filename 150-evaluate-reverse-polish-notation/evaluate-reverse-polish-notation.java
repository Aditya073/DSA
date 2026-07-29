class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {

            if (isInt(tokens[i])) {
                // if its a num push to the stack
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                // if its amoung +-*/  -->  pop the last 2 elements from the stack
                //   --> calculate the result and push it to the stack
                int second = stack.pop();
                int first = stack.pop();
                int res = 0;

                switch (tokens[i]) {
                    case "+":
                        res = first + second;
                        break;

                    case "-":
                        res = first - second;
                        break;

                    case "*":
                        res = first * second;
                        break;

                    case "/":
                        res = first / second;
                        break;
                }
                stack.push(res);
            }
        }

        return stack.pop();

    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}