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
    // globle variable
    int maxHeight = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxHeight;
    }
    // helper function
    public int getHeight(TreeNode root){
        if(root == null) return 0; // base case

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // to get the max value
        maxHeight = Math.max(maxHeight, leftHeight + rightHeight);
        return (1 + Math.max(leftHeight , rightHeight)); // current height of the node 
    }
}