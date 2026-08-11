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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int count = 1;
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sizeOfTheLevel = queue.size();

            List<Integer> perLevel = new ArrayList<>();
            for (int i = 0; i < sizeOfTheLevel; i++) {

                TreeNode temp = queue.poll();

                perLevel.add(temp.val);

                if (temp.left != null)
                    queue.offer(temp.left);

                if (temp.right != null)
                    queue.offer(temp.right);
            }

            if (count % 2 == 0) {
                Collections.reverse(perLevel);
            }

            ans.add(perLevel);
            count++;
        }

        return ans;
    }

    // public void zigzag(TreeNode temp) {
    //     if (count % 2 == 0) {
    //         if (temp.left != null) {
    //             queue.offer(temp.left);
    //         }
    //         if (temp.right != null) {
    //             queue.offer(temp.right);
    //         }

    //     } else {
    //         if (temp.right != null) {
    //             queue.offer(temp.right);
    //         }

    //         if (temp.left != null) {
    //             queue.offer(temp.left);
    //         }
    //     }

    // }
}