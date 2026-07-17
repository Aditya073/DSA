class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[9];
        for (int i = 1; i < 10; i++) {
            arr[i - 1] = i;
        }

        backtracking(ans, n, arr, new ArrayList<>(k), 0, k);
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int target, int[] arr, List<Integer> choise, int index,
            int length) {

        if (target == 0 && choise.size() == length) { // condition to add the choise in the final answer
            ans.add(new ArrayList<Integer>(choise));
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // add choise 
            choise.add(arr[i]);

            // backtack
            backtracking(ans, target - arr[i], arr, choise, i + 1, length);

            // undo the choise
            if (!choise.isEmpty()) {
                choise.remove(choise.size() - 1);
            }
        }

    }
}