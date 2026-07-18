class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtracking(ans, nums, new ArrayList<>(nums.length), visited);

        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int[] nums, List<Integer> choise, boolean[] visited) {

        if (choise.size() == nums.length) {
            ans.add(new ArrayList<>(choise));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue; // it checks if the current element is equal to the previous element && the prev element in the bool array is false than i++

            // addind condition
            choise.add(nums[i]);

            visited[i] = true;

            // backtrack
            backtracking(ans, nums, choise, visited);

            // undo the choised
            choise.remove(choise.size() - 1);
            // clear the visited HashSet
            visited[i] = false;
        }
    }

}