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
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean nullSeen = false;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left == null) {
                nullSeen = true;
            } else {
                if (nullSeen)
                    return false;
                else {
                    queue.offer(temp.left);
                }
            }

            if (temp.right == null) {
                nullSeen = true;
            } else {
                if (nullSeen)
                    return false;
                else {
                    queue.offer(temp.right);
                }
            }
        }
        return true;
    }
}