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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        if (root == null)
            return ans;
            
        dfs(ans, root, "");
        return ans;
    }

    public void dfs(List<String> ans, TreeNode root, String str) {
        if (root == null) {
            return;
        }

        if(str.isEmpty()){
            str = str + root.val;
        }
        else{
            str = str + "->" + root.val;
        }

        if(root.left == null && root.right == null){
            ans.add(str);
        }

        dfs(ans, root.left, str);
        dfs(ans, root.right, str);
    }
}