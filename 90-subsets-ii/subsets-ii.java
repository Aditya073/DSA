class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        backtracking(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int[] nums, List<Integer> choise, int index) {

        // add empty list
        ans.add(new ArrayList<>(choise));

        for (int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i-1]) continue;  // it checks if the current element is equal to the previous element if yes than i++

            choise.add(nums[i]);

            backtracking(ans, nums, choise, i + 1);

            choise.remove(choise.size() - 1);

        }

    }
}