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
    public int minDepth(TreeNode root) {
        int curr = 0;
        if (root == null)
            return curr;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sizeOfLevel = queue.size();
            curr++;

            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode temp = queue.poll();

                // First leaf encountered = minimum depth
                if (temp.left == null && temp.right == null) {
                    return curr;
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return curr;
    }

    // second approach
    /*
     public int minDepth(TreeNode root) {
     
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
       
    }
    */
}