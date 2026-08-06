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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();

            if(temp.val == targetSum && temp.right == null && temp.left == null){
                return true;
            }

            if(temp.right != null){
                temp.right.val += temp.val;
                stack.push(temp.right);
            }
            if(temp.left != null){
                temp.left.val += temp.val;
                stack.push(temp.left);
            }
        }

        return false;
    }
}