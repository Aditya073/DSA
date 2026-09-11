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
    int gl = 0;
    TreeNode g1fir, g1sec, g2fir, g2sec;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        helper(root);

        if (gl == 1) {
            swap(g1fir, g1sec);
        } else {
            swap(g1fir, g2sec);
        }
    }

    public void swap(TreeNode fst, TreeNode sec) {
        int temp = fst.val;
        fst.val = sec.val;
        sec.val = temp;
    }

    public void helper(TreeNode root) { // using in-order traversal
        if (root == null)
            return;

        helper(root.left);

        if (prev == null) {
            prev = root;
        } else {
            if (prev.val > root.val) {
                if (gl == 0) {
                    g1fir = prev;
                    g1sec = root;
                    gl++;
                } else {
                    g2fir = prev;
                    g2sec = root;
                    gl++;
                }
            }
            prev = root;
        }

        // for right side
        helper(root.right);
    }
}