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
    public List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return list.get(k-1);
    }

    // Inorder treversal on BST is always sorted
    public void inorder(TreeNode root, int k) {

        if (root == null) {
            return;
        }
        if(list.size() > k) return;
        inorder(root.left, k);
        list.add(root.val);
        inorder(root.right, k);

    }
}