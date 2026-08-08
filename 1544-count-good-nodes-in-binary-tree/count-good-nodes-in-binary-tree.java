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
    public int goodNodes(TreeNode root) {
        return  dfs(root, root.val);

    }

    public int dfs(TreeNode root,int mainRootVal){
        if(root == null) return 0;
        int count = 0;

        if(root.val >= mainRootVal){
            count = 1;
            mainRootVal = root.val;
        }
        
        count += dfs(root.left, mainRootVal);
        count += dfs(root.right, mainRootVal);

        return count;
    }
}