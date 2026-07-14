class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        backtracking(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, List<Integer> choise, int[] nums, int start) {

        ans.add(new ArrayList<>(choise)); // Add empty list
        for (int i = start; i < nums.length; i++) {

            choise.add(nums[i]);  // if number is included in the list

            backtracking(ans, choise, nums, i + 1); // backtrack

            choise.remove(choise.size()-1);  // if number is NOT included in the list
        }
    }
}