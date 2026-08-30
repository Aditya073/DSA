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
    /* pre-order treversal  root, left, right
    (0 * 0) + 1  ---> 1
    (0 * 1) + 2  ---> 12
    
    (0 * 3) + 1  ---> 13
    */
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return sum;
    }

    public void sum(TreeNode root, int currsum) {
        if (root == null) {
            return;
        }

        currsum = (currsum * 10) + root.val;
        // add to the final sum
        if(root.left == null && root.right == null){
            sum += currsum;
        }

        sum(root.left, currsum);
        sum(root.right, currsum);
        return;
    }
}