/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<>(), root, targetSum);
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, List<Integer> choise, TreeNode root, int target) {

        if (root == null)
            return;

        // add choise 
        choise.add(root.val);

        // Update target
        target = target - root.val;

        // condition to add the path in the ans
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<Integer>(choise));
        }

        backtracking(ans, choise, root.left, target);
        backtracking(ans, choise, root.right, target);

        // undo the choise
        if (!choise.isEmpty()) {
            choise.remove(choise.size() - 1);
        }

    }
}