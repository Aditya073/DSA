class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(candidates); 
        backtracking(ans, candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int[] candidates, int target, List<Integer> set, int index) {

        if (target == 0) {
            ans.add(new ArrayList<Integer>(set));
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (i != index && candidates[i] == candidates[i - 1])
                continue; // it checks if the current element is equal to the previous element if yes than i++

            set.add(candidates[i]);
            backtracking(ans, candidates, target - candidates[i], set, i + 1);

            if (!set.isEmpty()) {
                set.remove(set.size() - 1);
            }
        }

    }
}