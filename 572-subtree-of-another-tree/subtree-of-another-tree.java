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
    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        
        if(s == null || t == null) return false;

        if(s.val != t.val) return false;
        // till now the val of both the TreeNode are not null and same

        // now we check for both of their left and right parts
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        
        // give the roots to the "isSame" fun to check if they are same or not 
        if(isSame(root, subRoot)){
            // if they are same
            return true;
        }
        // if not then iterate through the main tree
        return(isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
}