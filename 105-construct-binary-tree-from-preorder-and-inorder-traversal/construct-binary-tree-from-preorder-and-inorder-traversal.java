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
    // HashSet to check visited
    // recursion to create the tree

    int preorderIndex;
    Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndex = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inorderIndex.put(inorder[i], i);
        }

       return arrayToTree(preorder, 0, preorder.length-1);
        
    }

    public TreeNode arrayToTree(int[] preorder, int left, int right){
        // base case
        if(left > right){
            return null;
        }

        int rootVal = preorder[preorderIndex];
        preorderIndex++;

        TreeNode tree = new TreeNode(rootVal);

        tree.left = arrayToTree(preorder, left, inorderIndex.get(rootVal)-1);
        tree.right = arrayToTree(preorder, inorderIndex.get(rootVal)+1, right);
        return tree;
    }
}