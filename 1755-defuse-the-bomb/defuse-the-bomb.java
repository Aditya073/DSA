class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) {
            return ans;
        } else if (k > 0) {
            int sum = 0;

            // First window: next k elements after index 0
            for (int i = 1; i <= k; i++) {
                sum += code[i % code.length];
            }

            for (int i = 0; i < code.length; i++) {
                ans[i] = sum;

                // Remove the first element of the current window
                sum -= code[(i + 1) % code.length];

                // Add the next element entering the window
                sum += code[(i + k + 1) % code.length];
            }

            return ans;
        } else {
            k = -k;
            int sum = 0;

            // First window: previous k elements for index 0
            for (int i = 1; i <= k; i++) {
                sum += code[(code.length - i) % code.length];
                System.out.println("first window" + sum);
            }

            for (int i = 0; i < code.length; i++) {
                ans[i] = sum;

                // Remove the farthest previous element
                sum -= code[(i - k + code.length) % code.length];

                // Add the current element (becomes previous for the next index)
                sum += code[i];
            }
        }
        return ans;
    }
}