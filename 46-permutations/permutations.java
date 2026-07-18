class Solution {
    public List<List<Integer>> permute(int[] nums) {
        HashSet <Integer> visited = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        backtracking(ans, nums, visited, new ArrayList<>(nums.length));

        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int[] nums, HashSet <Integer> visited, List<Integer> choise){

        if(choise.size() == nums.length){
            ans.add(new ArrayList<>(choise));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // if the no. is in the HashSet then move to the next no.
            if(visited.contains(nums[i])) continue;

            // addind condition
            choise.add(nums[i]);
            visited.add(nums[i]);
            
            // backtrack
            backtracking(ans, nums, visited, choise);

            // undo the choised
            choise.remove(choise.size() - 1);
            // clear the visited HashSet
            visited.remove(nums[i]);
        }
    }
}