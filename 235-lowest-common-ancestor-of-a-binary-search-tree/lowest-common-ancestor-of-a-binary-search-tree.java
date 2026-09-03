/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // First Approach

        // if (root.val > p.val && root.val > q.val) {
        //     return lowestCommonAncestor(root.left, p, q);
        // }
        // if (root.val < p.val && root.val < q.val) {
        //     return lowestCommonAncestor(root.right, p, q);
        // } else {
        //     return root;
        // }
        
        // Second Approach

        int pVal = p.val;
        int qVal = q.val;

        if (root == null ||
                (root.val >= pVal && root.val <= qVal) ||
                (root.val >= qVal && root.val <= pVal)) {

            return root;
        }

        if (root.val > pVal && root.val > qVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

}